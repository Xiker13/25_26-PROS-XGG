/**
 * Clase principal que inicia la ejecución de la actividad 14.
 * Crea dos recursos y dos hilos que intentan sincronizarse sobre esos recursos.
 */
public class Actividad14 extends Thread {

    /**
     * Método principal que inicia la ejecución de los hilos.
     * Crea dos objetos Recurso y dos hilos Hilo.
     * @param args los argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String args[]) {
        Recurso a = new Recurso();
        Recurso b = new Recurso();
        Hilo h1 = new Hilo(a, b, "uno");
        Hilo h2 = new Hilo(a, b, "dos");
        // Se inicia la ejecución de ambos hilos
        h1.start();
        h2.start();
    }
}

/**
 * Clase que representa un hilo que intenta trabajar con dos recursos.
 * Cada hilo intenta obtener un candado sobre los recursos para simular una operación crítica.
 */
class Hilo extends Thread {

    /** Primer recurso a sincronizar */
    Recurso a;

    /** Segundo recurso a sincronizar */
    Recurso b;

    /**
     * Constructor de la clase Hilo.
     * @param a primer recurso a sincronizar
     * @param b segundo recurso a sincronizar
     * @param nombre nombre del hilo
     */
    public Hilo(Recurso a, Recurso b, String nombre) {
        super(nombre);
        this.a = a;
        this.b = b;
    }

    /**
     * Método que se ejecuta al iniciar el hilo.
     * Sincroniza sobre el primer recurso, espera 100 ms y luego intenta sincronizar sobre el segundo recurso.
     * Imprime mensajes indicando el inicio y fin de la ejecución del hilo.
     */
    public void run() {
        System.out.println("Hilo " + this.getName() + " comienza");
        synchronized(a) {
            try {
                Thread.sleep(100); // Simula trabajo con el recurso
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b) {
                // Se podría añadir lógica adicional aquí
            }
            System.out.println("Hilo " + this.getName() + " ha terminado");
        }
    }
}

/**
 * Clase que representa un recurso compartido.
 * Actualmente es una clase vacía, pero se utiliza para la sincronización entre hilos.
 */
class Recurso {
}
