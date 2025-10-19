package org.example;

import java.io.*;

public class Ejemplo2 {

    public static void main(String[] args) {

        // Comando según el sistema operativo
        String comando = System.getProperty("os.name").toLowerCase().contains("win")
                ? "cmd /c dir"
                : "ls -al";

        // Crear ProcessBuilder con el comando separado
        ProcessBuilder builder = new ProcessBuilder(comando.split(" "));

        // Redirigir errores a salida estándar
        builder.redirectErrorStream(true);

        Process proceso = null;

        try {
            // Iniciar el proceso
            proceso = builder.start();

            // Leer salida del proceso
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int exitCode = proceso.waitFor();
            System.out.println("Valor de salida: " + exitCode);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
