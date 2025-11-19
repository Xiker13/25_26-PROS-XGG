import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {

    public static void main(String[] args) {
        try {
            // Obtener todas las direcciones IP del dominio
            InetAddress[] direcciones = InetAddress.getAllByName("www.spotify.com");

            System.out.println("Direcciones asociadas a Spotify:\n");
            for (InetAddress direccion : direcciones)
            {
                System.out.println(direccion);
            }
        } catch (UnknownHostException e) {
            System.err.println("No se ha podido conseguir las IP: " + e.getMessage());
        }
    }


}
