#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <errno.h>
#include <string.h>

int main(void) {
    int fp;
    char buffer[1024];
    ssize_t bytes;

    // Crear FIFO si no existe
    if (access("FIFO2", F_OK) == -1) {
        if (mkfifo("FIFO2", 0666) == -1) {
            perror("Error al crear FIFO");
            exit(1);
        }
    }

    // Abrir FIFO en modo lectura no bloqueante
    fp = open("FIFO2", O_RDONLY | O_NONBLOCK);
    if (fp == -1) {
        perror("Error al abrir FIFO");
        exit(1);
    }

    printf("Lector iniciado, esperando mensajes...\n");

    while (1) {
        bytes = read(fp, buffer, sizeof(buffer)-1);
        if (bytes > 0) {
            buffer[bytes] = '\0';
            printf("Obteniendo información...%s", buffer);
        } else if (bytes == -1 && errno != EAGAIN) {
            perror("Error leyendo FIFO");
        }
        // Evitar consumir CPU sin pausa
        usleep(100000); // 0.1 segundos
    }

    close(fp);
    return 0;
}
