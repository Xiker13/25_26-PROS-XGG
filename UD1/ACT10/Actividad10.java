package org.example;

public class Actividad10 {
    public static void main(String[] args) {
        // Obtener hilo principal
        Thread hiloPrincipal = Thread.currentThread();
        System.out.println(hiloPrincipal.getName() + " tiene la prioridad " + hiloPrincipal.getPriority());

        // Crear hilos con mensajes
        Hilo hilo3 = new Hilo("Hilo-prioridad 3");
        Hilo hilo7 = new Hilo("Hilo-prioridad 7");

        // Asignar prioridades
        hilo3.setPriority(3);
        hilo7.setPriority(7);

        // Mostrar prioridades de los hilos
        System.out.println(hilo3.getName() + " tiene la prioridad " + hilo3.getPriority());
        System.out.println(hilo7.getName() + " tiene la prioridad " + hilo7.getPriority());

        // Iniciar primero el hilo de prioridad 7
        hilo7.start();
        try {
            hilo7.join();  // esperar a que termine antes de continuar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir Final programa
        System.out.println("Final programa");

        // Iniciar el hilo de prioridad 3
        hilo3.start();
        try {
            hilo3.join();  // esperar a que termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
