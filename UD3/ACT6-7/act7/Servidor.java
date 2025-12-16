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
 * Autor: Xiker García de Albeniz
 */
public class Servidor {

    public static void main(String[] args) {
        final int PUERTO = 6013;

        System.out.println("Esperando a los clientes.....");

        ServerSocket serverSocket = null;
        Socket clienteSocket = null;
        DataOutputStream salida = null;

        try {
            serverSocket = new ServerSocket(PUERTO);

            for (int i = 1; i <= 3; i++) {
                try {
                    clienteSocket = serverSocket.accept();
                    salida = new DataOutputStream(clienteSocket.getOutputStream());

                    salida.writeUTF("Hola cliente " + i);

                } catch (IOException e) {
                    System.err.println("Error al atender al cliente " + i + ": " + e.getMessage());
                } finally {
                    try {
                        if (salida != null) salida.close();
                        if (clienteSocket != null) clienteSocket.close();
                    } catch (IOException ex) {
                        System.err.println("Error al cerrar recursos del cliente: " + ex.getMessage());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar el ServerSocket: " + ex.getMessage());
            }
        }
    }
}
