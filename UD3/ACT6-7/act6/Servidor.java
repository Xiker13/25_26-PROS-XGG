package act6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor TCP que recibe un número del cliente,
 * calcula su cuadrado y se lo devuelve.
 *
 * Puerto utilizado: 6010
 *
 * Autor: Xiker García de Albeniz
 */
public class Servidor {

    public static void main(String[] args) {
        final int PUERTO = 6010;

        ServerSocket serverSocket = null;
        Socket clienteSocket = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;

        try {
            serverSocket = new ServerSocket(PUERTO);

            System.out.println("Esperando al cliente.....");

            clienteSocket = serverSocket.accept();

            System.out.println("Cliente conectado. Preparando flujo de entrada...");

            entrada = new DataInputStream(clienteSocket.getInputStream());
            salida = new DataOutputStream(clienteSocket.getOutputStream());

            int numero = entrada.readInt();
            int resultado = numero * numero;

            salida.writeUTF("El cuadrado del número " + numero + " es " + resultado);

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (salida != null) salida.close();
                if (clienteSocket != null) clienteSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
}
