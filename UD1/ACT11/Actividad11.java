package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad11 {
    public static void main(String[] args) {
        // Comando según el sistema operativo
        String comando;

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            // Comando para Windows
            comando = "cmd /c dir";
        } else {
            // Comando paras Linux o Mac
            comando = "ls -l";
        }

        try {
            // Crear ProcessBuilder con el comando separado
            ProcessBuilder pb = new ProcessBuilder(comando.split(" "));
            Process proceso = pb.start();

            // Capturar la salida del comando
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar a que termine el proceso
            int codigoSalida = proceso.waitFor();
            System.out.println("El comando finalizo con codigo: " + codigoSalida);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
