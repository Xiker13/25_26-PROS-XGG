#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MSG_SIZE 100

int main() {
    int pipe_ab_ha[2]; // abuelo -> hijo
    int pipe_ha_ab[2]; // hijo -> abuelo
    int pipe_ha_nh[2]; // hijo -> nieto
    int pipe_nh_ha[2]; // nieto -> hijo

    pipe(pipe_ab_ha);
    pipe(pipe_ha_ab);
    pipe(pipe_ha_nh);
    pipe(pipe_nh_ha);

    pid_t pid_hijo = fork();

    if (pid_hijo < 0) {
        perror("fork");
        return 1;
    }

    if (pid_hijo == 0) {
        // ================= HIJO =================
        pid_t pid_nieto = fork();

        if (pid_nieto < 0) {
            perror("fork");
            return 1;
        }

        if (pid_nieto == 0) {
            // ================= NIETO =================
            close(pipe_ab_ha[0]); close(pipe_ab_ha[1]);
            close(pipe_ha_ab[0]); close(pipe_ha_ab[1]);
            close(pipe_ha_nh[1]); // nieto solo lee
            close(pipe_nh_ha[0]); // nieto solo escribe

            char msg[MSG_SIZE];
            read(pipe_ha_nh[0], msg, MSG_SIZE);
            printf("NIETO (PID=%d) recibe mensaje del HIJO: %s\n", getpid(), msg);

            char msg_nieto[] = "Saludo del NIETO...";
            printf("NIETO (PID=%d) envia mensaje al HIJO...\n", getpid());
            write(pipe_nh_ha[1], msg_nieto, strlen(msg_nieto)+1);

            close(pipe_ha_nh[0]);
            close(pipe_nh_ha[1]);
            return 0;
        } else {
            // ================= HIJO =================
            close(pipe_ab_ha[1]); // leer de abuelo
            close(pipe_ha_ab[0]); // escribir a abuelo
            close(pipe_ha_nh[0]); // escribir al nieto
            close(pipe_nh_ha[1]); // leer del nieto

            char msg[MSG_SIZE];

            // Recibe mensaje del abuelo
            read(pipe_ab_ha[0], msg, MSG_SIZE);
            printf("HIJO (PID=%d) recibe mensaje del ABUELO: %s\n", getpid(), msg);

            // Envía mensaje al nieto
            char msg_padre[] = "Saludo del HIJO..";
            printf("HIJO (PID=%d) envia mensaje al NIETO...\n", getpid());
            write(pipe_ha_nh[1], msg_padre, strlen(msg_padre)+1);

            // Recibe mensaje del nieto
            read(pipe_nh_ha[0], msg, MSG_SIZE);
            printf("HIJO (PID=%d) recibe mensaje del NIETO: %s\n", getpid(), msg);

            // Envía mensaje al abuelo
            char msg_hijo[] = "Saludo del HIJO...";
            printf("HIJO (PID=%d) envia mensaje al ABUELO...\n", getpid());
            write(pipe_ha_ab[1], msg_hijo, strlen(msg_hijo)+1);

            close(pipe_ab_ha[0]);
            close(pipe_ha_ab[1]);
            close(pipe_ha_nh[1]);
            close(pipe_nh_ha[0]);

            wait(NULL); // espera al nieto
            return 0;
        }
    } else {
        // ================= ABUELO =================
        close(pipe_ab_ha[0]); // solo escribe
        close(pipe_ha_ab[1]); // solo lee
        close(pipe_ha_nh[0]); close(pipe_ha_nh[1]);
        close(pipe_nh_ha[0]); close(pipe_nh_ha[1]);

        char msg_abuelo[] = "Saludo del ABUELO..";
        printf("ABUELO (PID=%d) envia mensaje al HIJO...\n", getpid());
        write(pipe_ab_ha[1], msg_abuelo, strlen(msg_abuelo)+1);
        close(pipe_ab_ha[1]);

        char msg[MSG_SIZE];
        read(pipe_ha_ab[0], msg, MSG_SIZE);
        printf("ABUELO (PID=%d) recibe mensaje del HIJO: %s\n", getpid(), msg);
        close(pipe_ha_ab[0]);

        wait(NULL); // espera al hijo
    }

    return 0;
}
