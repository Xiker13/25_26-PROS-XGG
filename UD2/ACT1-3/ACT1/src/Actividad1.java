/**
 * <h2>Clase Actividad1</h2>
 * Clase principal para ejecutar dos hilos que imprimen "Primero" y "Segundo" 20 veces.
 * Cada hilo es una instancia de la clase Hilo.
 *
 * @author Xiker
 * @version 1.0
 * @since 17-10-2025
 */
public class Actividad1 {
    /**
     * Procedimiento principal que crea y ejecuta los hilos.
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args){
        Hilo primero = new Hilo("Primero", 20);
        Hilo segundo = new Hilo("Segundo", 20);

        primero.start();
        segundo.start();

        System.out.println("Fin programa");
    }
}
