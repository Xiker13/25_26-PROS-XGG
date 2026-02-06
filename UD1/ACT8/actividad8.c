/**
 * UD1 – PROGRAMACIÓN MULTIPROCESO
 * Actividad 8
 * 
 * Enunciado:
 * Realiza un programa en C donde los procesos abuelo, hijo y nieto se envíen
 * mensajes de acuerdo al siguiente gráfico:
 * 
 *           fd1              fd2
 * ABUELO ---------> HIJO ----------> NIETO
 *        <---------      <----------
 *           fd2              fd1
 * 
 * Nota: como se puede observar en el gráfico, se utilizan 2 pipes.
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

/**
 * Actividad 8 - UD1 Programación Multiproceso
 * 
 * Implementación de un programa en C donde los procesos abuelo, hijo y nieto
 * se envían mensajes utilizando exactamente 2 pipes según el flujo indicado:
 * 
 * fd1: ABUELO -> HIJO y NIETO -> HIJO
 * fd2: HIJO -> NIETO y HIJO -> ABUELO
 */

int main() {
    int fd1[2]; // Pipe 1
    int fd2[2]; // Pipe 2
    char buffer[100];

    // Creación de los UNICOS 2 pipes solicitados
    if (pipe(fd1) == -1 || pipe(fd2) == -1) {
        perror("Error al crear los pipes");
        exit(EXIT_FAILURE);
    }

    // 1. El ABUELO envia un mensaje al HIJO.......
    printf("El ABUELO envia un mensaje al HIJO.......\n");
    
    pid_t pid_hijo = fork();

    if (pid_hijo < 0) {
        perror("Error en fork hijo");
        exit(EXIT_FAILURE);
    }

    if (pid_hijo == 0) { // ================= HIJO =================
        // 2. El HIJO recibe mensaje de abuelo: Saludo del abuelo..
        read(fd1[0], buffer, sizeof(buffer));
        printf("    El HIJO recibe mensaje de abuelo: %s\n", buffer);

        // 3. El HIJO envia un mensaje al NIETO......
        printf("    El HIJO envia un mensaje al NIETO......\n");

        pid_t pid_nieto = fork();

        if (pid_nieto < 0) {
            perror("Error en fork nieto");
            exit(EXIT_FAILURE);
        }

        if (pid_nieto == 0) { // ================= NIETO =================
            // 4. El NIETO recibe mensaje del padre: Saludo del padre..
            read(fd2[0], buffer, sizeof(buffer));
            printf("        El NIETO recibe mensaje del padre: %s\n", buffer);

            // 5. El NIETO envia un mensaje al HIJO.......
            printf("        El NIETO envia un mensaje al HIJO.......\n");
            strcpy(buffer, "Saludo del nieto...");
            write(fd1[1], buffer, strlen(buffer) + 1);

            close(fd1[0]); close(fd1[1]); close(fd2[0]); close(fd2[1]);
            exit(EXIT_SUCCESS);

        } else { // ================= HIJO (continuación) =================
            // Envío efectivo al nieto (paso 3)
            strcpy(buffer, "Saludo del padre..");
            write(fd2[1], buffer, strlen(buffer) + 1);

            // Esperar a que el nieto termine para que fd1 esté libre
            wait(NULL);

            // 6. El HIJO recibe mensaje de su hijo: Saludo del nieto...
            read(fd1[0], buffer, sizeof(buffer));
            printf("    El HIJO recibe mensaje de su hijo: %s\n", buffer);

            // 7. El HIJO envia un mensaje al ABUELO......
            printf("    El HIJO envia un mensaje al ABUELO......\n");
            strcpy(buffer, "Saludo del hijo..");
            write(fd2[1], buffer, strlen(buffer) + 1);

            close(fd1[0]); close(fd1[1]); close(fd2[0]); close(fd2[1]);
            exit(EXIT_SUCCESS);
        }

    } else { // ================= ABUELO =================
        // Envío efectivo al hijo (paso 1)
        strcpy(buffer, "Saludo del abuelo..");
        write(fd1[1], buffer, strlen(buffer) + 1);

        // Esperar a que el hijo (y el nieto) terminen todo el flujo
        wait(NULL);

        // 8. El ABUELO recibe mensaje del HIJO: Saludo del hijo..
        read(fd2[0], buffer, sizeof(buffer));
        printf("El ABUELO recibe mensaje del HIJO: %s\n", buffer);

        close(fd1[0]); close(fd1[1]); close(fd2[0]); close(fd2[1]);
    }

    return 0;
}
