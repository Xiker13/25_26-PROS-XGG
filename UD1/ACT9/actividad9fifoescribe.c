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
 * $./actividad9fifoescribe
 * Mandando información al FIFO…
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

int main (void)
{
	int fp;
	char saludo[] = "Un saludo....\n";

    // El programa actividad9fifoescribe será el encargado de crear el fifo.
    mkfifo("FIFO2", 0666);

	fp = open ("FIFO2", O_WRONLY);
	if (fp == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, strlen(saludo)); 	
	close (fp);
	return(0);
}
