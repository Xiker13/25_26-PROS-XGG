import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {

    public static void main(String[] args) {

        // Comprobar si se ha pasado un parámetro
        if (args.length == 0) {
            System.out.println("Se necesita una URL para obtener su dirección");
            return;
        }

        String url = args[0];

        try {
            // Obtener todas las direcciones IP asociadas al parámetro
            InetAddress[] direcciones = InetAddress.getAllByName(url);

            System.out.println("Las direcciones asociadas a " + url + " son:\n");

            for (InetAddress direccion : direcciones) {
                System.out.println(direccion);
            }

        } catch (UnknownHostException e) {
            System.err.println("No se pudieron obtener las direcciones para " + url + ": " + e.getMessage());
        }
    }
}
