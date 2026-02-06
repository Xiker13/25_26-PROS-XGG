/**
 * UD1 – PROGRAMACIÓN MULTIPROCESO
 * Actividad 9
 * 
 * Enunciado:
 * Modificar los programas C de nombre actividad9fifocrealee.c y actividad9fifoescribe.c, 
 * para que cuando se ejecute el programa actividad9fifoescribe, envíe al programa 
 * actividad9fifocrealee un mensaje para que éste lo visualice. 
 * El programa actividad9fifoescribe será el encargado de crear el fifo.
 * 
 * Resultado esperado:
 * $./actividad9fifocrea
 * Obteniendo información…Un saludo....
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	int fp;
	int bytesleidos;
	char buffer[10];
	
	// Este programa no crea el FIFO, lo crea el escritor.
    // Solo entramos en el bucle infinito para leer mensajes.

	while (1) {
		fp = open ("FIFO2", O_RDONLY);
        if (fp == -1) {
            // Si el FIFO no existe, esperamos un poco
            usleep(500000);
            continue;
        }

		printf("Obteniendo información..."); 
		while ((bytesleidos = read(fp, buffer, 1)) > 0) {
            buffer[bytesleidos] = '\0';
			printf("%s", buffer);
		}
	    close (fp);
    }
    return(0);
}

/* 
 * NOTA: Si quisieras que el proceso terminara justo después de recibir 
 * el primer mensaje (en lugar de estar en un bucle infinito), 
 * el código sería así:
 * 
 * int main(void) {
 *     int fp, bytesleidos;
 *     char buffer[10];
 *
 *     fp = open("FIFO2", O_RDONLY);
 *     if (fp != -1) {
 *         printf("Obteniendo información..."); 
 *         while ((bytesleidos = read(fp, buffer, 1)) > 0) {
 *             buffer[bytesleidos] = '\0';
 *             printf("%s", buffer);
 *         }
 *         close(fp);
 *     }
 *     return 0;
 * }
 */
