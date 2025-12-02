package act6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Cliente TCP que solicita al usuario un número entero,
 * lo envía al servidor y muestra el resultado recibido.
 *
 * Se conecta al puerto 6010 del servidor.
 *
 * @author Xiker García de Albeniz
 */
public class Cliente {

    /**
     * Método principal del cliente.
     * Captura un número por teclado, lo envía al servidor y muestra la respuesta.
     *
     * @param args No se utilizan.
     */
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6010;

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");

        int numero = sc.nextInt();

        try (Socket socket = new Socket(HOST, PUERTO);
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             DataInputStream entrada = new DataInputStream(socket.getInputStream())) {

            salida.writeInt(numero);

            String respuesta = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: \n\t" + respuesta);

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
