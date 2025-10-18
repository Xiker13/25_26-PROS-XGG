#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
    int n;
    printf("Introduce la cantidad de hijos (n): ");
    scanf("%d", &n);

    pid_t pid;
    int i;

    printf("Soy el padre inicial, PID = %d\n", getpid());

    for(i = 1; i <= n; i++) {
        pid = fork();

        if(pid < 0) {
            perror("fork");
            exit(1);
        }

        if(pid == 0) {
            // Hijo creado
            printf("Soy el hijo %d, PID = %d, mi padre es %d\n", i, getpid(), getppid());
            // El hijo continúa el bucle para crear el siguiente hijo
        } else {
            // El proceso padre original espera a su hijo antes de terminar
            wait(NULL);
            break; // Evita que el padre original siga creando más hijos
        }
    }

    return 0;
}
