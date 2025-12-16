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
 * Autor: Xiker García de Albeniz
 */
public class Cliente {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6013;

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        Socket socket = null;
        DataInputStream entrada = null;

        try {
            socket = new Socket(HOST, PUERTO);
            entrada = new DataInputStream(socket.getInputStream());

            String mensaje = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: \n\t" + mensaje);

        } catch (IOException e) {
            System.err.println("Connection refused: connect");
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
}
