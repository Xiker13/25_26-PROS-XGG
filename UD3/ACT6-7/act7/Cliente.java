package act7;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Cliente TCP que se conecta al servidor en el puerto 6013
 * y muestra el mensaje de saludo recibido.
 *
 * Si el servidor ya ha atendido a 3 clientes, la conexión será rechazada.
 *
 * @author Xiker García de Albeniz
 */
public class Cliente {

    /**
     * Método principal del cliente.
     * Se conecta al servidor y muestra el saludo recibido.
     *
     * @param args No se utilizan.
     */
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6013;

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try (Socket socket = new Socket(HOST, PUERTO);
             DataInputStream entrada = new DataInputStream(socket.getInputStream())) {

            String mensaje = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: \n\t" + mensaje);

        } catch (IOException e) {
            System.err.println("Connection refused: connect");
        }
    }
}
