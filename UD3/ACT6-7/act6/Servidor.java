package act6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor TCP que recibe un número entero por parte del cliente,
 * calcula su cuadrado y se lo devuelve.
 *
 * Puerto utilizado: 6010
 *
 * @author Xiker García de Albeniz
 */
public class Servidor {

    /**
     * Método principal del servidor.
     * Inicia un ServerSocket, espera al cliente y procesa la petición.
     *
     * @param args No se utilizan.
     */
    public static void main(String[] args) {
        final int PUERTO = 6010;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Esperando al cliente.....");

            try (Socket clienteSocket = serverSocket.accept();
                 DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
                 DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream())) {

                System.out.println("Cliente conectado. Preparando flujo de entrada...");

                int numero = entrada.readInt();
                int resultado = numero * numero;

                salida.writeUTF("El cuadrado del número " + numero + " es " + resultado);
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
