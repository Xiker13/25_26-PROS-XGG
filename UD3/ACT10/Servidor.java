import java.io.*;
import java.net.*;

/**
 * Programa servidor que recibe un objeto {@link Tenista} a través de UDP,
 * modifica sus atributos y lo devuelve al cliente.
 *
 * <p>
 * El servidor escucha peticiones en el puerto 12348.
 * </p>
 *
 * Muestra por pantalla la información del objeto recibido,
 * la IP y el puerto del cliente, y los datos del objeto modificado.
 *
 * @author Xiker
 */
public class Servidor {

    /**
     * Método principal del servidor.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        DatagramSocket socket = null;

        try {
            // Creación del socket UDP en el puerto 12348
            socket = new DatagramSocket(12348);

            System.out.println("Esperando datagrama.......");

            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibido =
                    new DatagramPacket(buffer, buffer.length);

            socket.receive(paqueteRecibido);

            // Deserialización del objeto recibido
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(paqueteRecibido.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);

            Tenista tenista = (Tenista) ois.readObject();

            System.out.println("Recibo el objeto: " +
                    tenista.getApellido() + " " + tenista.getAltura());

            System.out.println("IP de origen: " +
                    paqueteRecibido.getAddress());
            System.out.println("Puerto de origen: " +
                    paqueteRecibido.getPort());

            // Modificación del objeto Tenista
            tenista.setApellido("Karlovic");
            tenista.setAltura(208);

            System.out.println("Envío el objeto: " +
                    tenista.getApellido() + " " + tenista.getAltura());

            // Serialización del objeto modificado
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();

            byte[] datosEnvio = baos.toByteArray();

            DatagramPacket paqueteEnvio =
                    new DatagramPacket(
                            datosEnvio,
                            datosEnvio.length,
                            paqueteRecibido.getAddress(),
                            paqueteRecibido.getPort());

            socket.send(paqueteEnvio);

            System.out.println("Fin del servidor");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierre del socket
            if (socket != null) {
                socket.close();
            }
        }
    }
}
