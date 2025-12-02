package act7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor TCP que atiende exactamente a 3 clientes y
 * envía a cada uno un saludo personalizado.
 *
 * Puerto utilizado: 6013
 *
 * @author Xiker García de Albeniz
 */
public class Servidor {

    /**
     * Método principal del servidor.
     * Acepta tres conexiones y envía un mensaje de saludo a cada cliente.
     *
     * @param args No se utilizan.
     */
    public static void main(String[] args) {
        final int PUERTO = 6013;
        System.out.println("Esperando a los clientes.....");

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            for (int i = 1; i <= 3; i++) {
                try (Socket clienteSocket = serverSocket.accept();
                     DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream())) {

                    salida.writeUTF("Hola cliente " + i);

                } catch (IOException e) {
                    System.err.println("Error al atender al cliente " + i + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
