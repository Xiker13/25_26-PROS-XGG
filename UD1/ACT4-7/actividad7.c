#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int valor = 6;
    pid_t pid;

    printf("Valor inicial de la variable: %d\n", valor);

    pid = fork();

    if(pid < 0) {
        perror("fork");
        return 1;
    }

    if(pid == 0) {
        // Proceso hijo
        valor -= 5;
        printf("Variable en Proceso Hijo: %d\n", valor);
    } else {
        // Proceso padre
        valor += 5;
        // Espera a que el hijo termine para mantener el orden en la salida
        wait(NULL);
        printf("Variable en Proceso Padre: %d\n", valor);
    }

    return 0;
}
