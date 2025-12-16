package act6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Cliente TCP que solicita un número entero por teclado,
 * lo envía al servidor y muestra el resultado recibido.
 *
 * Puerto utilizado: 6010
 *
 * Autor: Xiker García de Albeniz
 */
public class Cliente {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6010;

        System.out.println("PROGRAMA CLIENTE INICIANDO");
        System.out.println("Introduce un número");

        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        Socket socket = null;
        DataOutputStream salida = null;
        DataInputStream entrada = null;

        try {
            socket = new Socket(HOST, PUERTO);

            salida = new DataOutputStream(socket.getOutputStream());
            entrada = new DataInputStream(socket.getInputStream());

            salida.writeInt(numero);

            String respuesta = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: \n\t" + respuesta);

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) entrada.close();
                if (salida != null) salida.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }

            sc.close();
        }
    }
}
