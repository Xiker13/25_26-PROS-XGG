import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Crear el socket UDP
            socket = new DatagramSocket(34568); // Puerto local
            InetAddress servidor = InetAddress.getByName("localhost"); // Dirección IP del servidor
            int puertoServidor = 12346; // Puerto donde escucha el servidor

            // Número a enviar (definido en el código)
            int numero = 4;

            // Enviar el número al servidor
            byte[] mensaje = Integer.toString(numero).getBytes();
            DatagramPacket paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, servidor, puertoServidor);
            socket.send(paqueteEnvio);

            // Imprimir mensaje de espera
            System.out.println("Esperando respuesta...");

            // Recibir la respuesta del servidor
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecepcion = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecepcion);

            // Convertir el mensaje recibido (cubo del número)
            String respuesta = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());

            // Mostrar el resultado
            System.out.println("Esperando respuesta....: el cubo de " + numero + " es " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el socket
            if (socket != null && !socket.isClosed()) {
                System.out.println("Adiós…");
                socket.close();
            }
        }
    }
}
