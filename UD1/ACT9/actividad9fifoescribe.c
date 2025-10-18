#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(void) {
    int fp;
    char saludo[] = "Un saludo !!!!!\n";

    // Crear FIFO si no existe
    if (access("FIFO2", F_OK) == -1) {
        if (mkfifo("FIFO2", 0666) == -1) {
            perror("Error al crear FIFO");
            exit(1);
        }
    }

    // Abrir FIFO en modo escritura bloqueante
    fp = open("FIFO2", O_WRONLY);
    if (fp == -1) {
        perror("Error al abrir FIFO");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");
    write(fp, saludo, sizeof(saludo));
    close(fp);

    return 0;
}
