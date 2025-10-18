#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    int i;

    printf("Soy el padre %d\n", getpid());

    for(i = 1; i <= 3; i++) {
        pid = fork();

        if(pid < 0) {
            // Error al crear el hijo
            perror("fork");
            return 1;
        }
        if(pid == 0) {
            // Esto lo ejecuta el hijo
            printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i, getppid(), getpid());
            return 0; // Termina el hijo
        }
        // El padre continúa el bucle para crear los siguientes hijos
    }

    // El padre espera a que terminen todos los hijos
    for(i = 0; i < 3; i++) {
        wait(NULL);
    }

    return 0;
}
