/**
 * <h2>Clase Actividad2</h2>
 * Crea n hilos, donde n se pasa como argumento.
 * Cada hilo imprime "Hilo n i" 20 veces.
 * Al finalizar la creación de hilos, muestra "Final Programa".
 *
 * @author Xiker
 * @version 1.0
 * @since 17-10-2025
 */
public class Actividad2 {

    /**
     * Clase interna que representa un hilo de trabajo.
     */
    static class Worker extends Thread {
        private int id;
        private int repeticiones;

        /**
         * Constructor del hilo.
         * @param id Número del hilo
         * @param repeticiones Número de veces que imprimirá
         */
        public Worker(int id, int repeticiones){
            this.id = id;
            this.repeticiones = repeticiones;
        }

        /**
         * Procedimiento que se ejecuta al iniciar el hilo.
         * Imprime "Hilo id i" 20 veces.
         */
        @Override
        public void run() {
            for(int i = 1; i <= repeticiones; i++){
                System.out.println("Hilo " + id + " " + i);
            }
        }
    }

    /**
     * Procedimiento principal que crea n hilos y los ejecuta.
     * @param args El primer argumento debe ser el número de hilos a crear
     */
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Uso: java Actividad2 <número_de_hilos>");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
            if(n <= 0){
                System.out.println("El número de hilos debe ser positivo.");
                return;
            }
        } catch(NumberFormatException e){
            System.out.println("Argumento no válido. Debe ser un número entero.");
            return;
        }

        for(int i = 1; i <= n; i++){
            Worker w = new Worker(i, 20);
            w.start();
        }

        System.out.println("Final Programa");
    }
}
