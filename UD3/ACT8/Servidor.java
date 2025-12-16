import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Crear el socket UDP para escuchar en el puerto 12346
            socket = new DatagramSocket(12346); // Puerto servidor
            System.out.println("Esperando datagrama...");

            while (true) {
                // Crear un buffer para recibir datos
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteRecepcion = new DatagramPacket(buffer, buffer.length);

                // Recibir el datagrama del cliente
                socket.receive(paqueteRecepcion);

                // Extraer el número enviado por el cliente
                String mensajeRecibido = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                int numero = Integer.parseInt(mensajeRecibido);

                // Mostrar información sobre el número recibido
                System.out.println("Vamos a calcular el cubo de: " + numero);
                System.out.println("IP de origen: " + paqueteRecepcion.getAddress());
                System.out.println("Puerto de origen: " + paqueteRecepcion.getPort());

                // Calcular el cubo del número
                int cubo = (int) Math.pow(numero, 3);

                // Enviar el resultado de vuelta al cliente
                String respuesta = Integer.toString(cubo);
                byte[] mensajeRespuesta = respuesta.getBytes();
                DatagramPacket paqueteRespuesta = new DatagramPacket(mensajeRespuesta, mensajeRespuesta.length, paqueteRecepcion.getAddress(), paqueteRecepcion.getPort());
                socket.send(paqueteRespuesta);

                // Mostrar el resultado enviado
                System.out.println("Enviamos el resultado..." + cubo);
                System.out.println("Adiósss");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el socket
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
