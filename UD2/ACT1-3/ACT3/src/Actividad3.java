/**
 * <h2>Clase Actividad3</h2>
 * Demuestra el uso de los métodos setName(), getName(), setPriority() y getPriority() de la clase Thread.
 * Cambia el nombre y la prioridad de un hilo y muestra los valores antes y después del cambio.
 *
 * @author Xiker
 * @version 1.0
 * @since 17-10-2025
 */
public class Actividad3 {
    /**
     * Procedimiento principal que crea un hilo, muestra sus valores, los modifica y los vuelve a mostrar.
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args){
        Thread t = new Thread();

        System.out.println("El nombre del hilo es " + t.getName() + " y tiene la prioridad " + t.getPriority());
        System.out.println();

        t.setName("SUPER-HILO-DM2");
        t.setPriority(6);

        System.out.println("Ahora el nombre del hilo es " + t.getName() + " y tiene la prioridad " + t.getPriority());
        System.out.println();

        System.out.println("Final programa");
    }
}
