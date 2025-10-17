/**
 * <h2>Clase Hilo</h2>
 * Esta clase representa un hilo que imprime un nombre y un número de repeticiones.
 * Se utiliza en la Actividad 1 de la Unidad 2 para reemplazar las clases Primero y Segundo.
 *
 * @author Xiker
 * @version 1.0
 * @since 17-10-2025
 */
public class Hilo extends Thread {
    /**
     * Nombre que imprime el hilo.
     */
    private String nombre;

    /**
     * Número de repeticiones que hará el hilo.
     */
    private int repeticiones;

    /**
     * Constructor del hilo.
     * @param nombre Nombre a imprimir
     * @param repeticiones Número de veces que imprimirá
     */
    public Hilo(String nombre, int repeticiones){
        this.nombre = nombre;
        this.repeticiones = repeticiones;
    }

    /**
     * Procedimiento que se ejecuta al iniciar el hilo.
     * Imprime el nombre seguido del contador de 1 a repeticiones.
     */
    @Override
    public void run() {
        for(int i = 1; i <= repeticiones; i++){
            System.out.println(nombre + " " + i);
        }
    }
}
