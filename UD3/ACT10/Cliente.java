import java.io.*;
import java.net.*;

/**
 * Programa cliente que envía un objeto {@link Tenista} a un servidor UDP
 * y recibe dicho objeto modificado.
 *
 * <p>
 * El cliente utiliza el puerto local 34567 y envía el datagrama
 * al puerto 12348 del servidor (localhost).
 * </p>
 *
 * Muestra por pantalla el estado del objeto antes del envío
 * y después de la recepción.
 *
 * @author Xiker
 */
public class Cliente {

    /**
     * Método principal del cliente.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        DatagramSocket socket = null;

        try {
            // Creación del socket UDP en el puerto 34567
            socket = new DatagramSocket(34567);

            // Instanciación del objeto Tenista
            Tenista tenista = new Tenista("del Potro", 198);

            // Serialización del objeto Tenista
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(tenista);
            oos.flush();

            byte[] datos = baos.toByteArray();

            // Creación y envío del datagrama al servidor
            DatagramPacket paqueteEnvio =
                    new DatagramPacket(datos, datos.length,
                            InetAddress.getByName("localhost"), 12348);

            socket.send(paqueteEnvio);

            System.out.println("Envío el objeto: " +
                    tenista.getApellido() + " " + tenista.getAltura());

            // Espera del datagrama de respuesta
            System.out.println("Esperando datagrama.......");

            byte[] bufferRecepcion = new byte[1024];
            DatagramPacket paqueteRecepcion =
                    new DatagramPacket(bufferRecepcion, bufferRecepcion.length);

            socket.receive(paqueteRecepcion);

            // Deserialización del objeto recibido
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(paqueteRecepcion.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);

            Tenista recibido = (Tenista) ois.readObject();

            System.out.println("He recibido el objeto: " +
                    recibido.getApellido() + "  " + recibido.getAltura());

            System.out.println("Fin del cliente");

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
