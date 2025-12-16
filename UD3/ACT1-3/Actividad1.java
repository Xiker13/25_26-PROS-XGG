import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Actividad1
 *
 * Programa que obtiene y muestra todas las direcciones IP asociadas
 * al dominio "www.spotify.com" utilizando la clase InetAddress de Java.
 *
 * Salida esperada:
 * Direcciones asociadas a Spotify:
 * www.spotify.com/...
 * (las IPs pueden variar)
 *
 * @author Xiker
 */
public class Actividad1 {

    /**
     * Método principal que ejecuta el programa.
     * Intenta obtener todas las direcciones IP del dominio "www.spotify.com"
     * y las imprime en pantalla. Si ocurre un error al resolver el dominio,
     * se muestra un mensaje de error.
     *
     * @param args argumentos de línea de comandos (no se utilizan en este programa)
     */
    public static void main(String[] args) {
        try {
            // Obtener todas las direcciones IP del dominio
            InetAddress[] direcciones = InetAddress.getAllByName("www.spotify.com");

            System.out.println("Direcciones asociadas a Spotify:\n");
            for (InetAddress direccion : direcciones) {
                System.out.println(direccion);
            }
        } catch (UnknownHostException e) {
            System.err.println("No se ha podido conseguir las IP: " + e.getMessage());
        }
    }
}
