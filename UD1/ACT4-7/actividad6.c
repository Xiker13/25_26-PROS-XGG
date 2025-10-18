#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid1, pid2, pid3;

    // Padre crea hijo 1
    pid1 = fork();
    if(pid1 < 0) {
        perror("fork");
        return 1;
    }
    if(pid1 == 0) {
        // Hijo 1
        printf("Yo soy el hijo 1, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        return 0;
    }

    // Padre crea hijo 2
    pid2 = fork();
    if(pid2 < 0) {
        perror("fork");
        return 1;
    }
    if(pid2 == 0) {
        // Hijo 2
        printf("Yo soy el hijo 2, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());

        // Hijo 2 crea hijo 3
        pid3 = fork();
        if(pid3 < 0) {
            perror("fork");
            return 1;
        }
        if(pid3 == 0) {
            // Hijo 3
            printf("Yo soy el hijo 3, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
            return 0;
        }

        // Hijo 2 espera a hijo 3
        wait(NULL);
        return 0;
    }

    // Padre espera a hijo 1 y hijo 2
    wait(NULL);
    wait(NULL);

    return 0;
}
