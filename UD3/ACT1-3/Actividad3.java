import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Actividad3
 *
 * Programa que recibe como parámetro un nombre de dominio y devuelve su dirección IP.
 * Si no se le pasa ningún parámetro válido, devuelve las direcciones IP locales
 * del equipo. Utiliza la clase InetAddress para obtener la información de red.
 *
 * Salida esperada:
 * - Con dominio:
 *   Dirección IP: <IP del dominio>
 *   Nombre: <nombre del dominio>
 *   <nombre>/<IP>
 *   <IP>
 *   <nombre>/<IP>
 *
 * - Sin parámetros:
 *   Dirección IP: <IP principal local>
 *   Nombre: <nombre del host local>
 *   <nombre>/<IP principal>
 *   <IP principal>
 *   <nombre>/<IP principal>
 *   <nombre>/<otras IPs locales>
 *
 * @author Xiker
 */
public class Actividad3 {

    /**
     * Método principal que ejecuta el programa.
     * Dependiendo de si se pasa un argumento:
     * - No se pasa: llama a mostrarDireccionesLocales().
     * - Se pasa un dominio: llama a mostrarDireccionDeDominio(dominio).
     *
     * @param args argumentos de línea de comandos; el primer argumento opcional
     *             es el nombre de dominio a resolver.
     */
    public static void main(String[] args) {

        // Caso 1: NO se pasa ningún parámetro → direcciones locales
        if (args.length == 0) {
            mostrarDireccionesLocales();
            return;
        }

        // Caso 2: Se pasa un dominio
        String dominio = args[0];
        mostrarDireccionDeDominio(dominio);
    }

    /**
     * Muestra la dirección IP y el nombre del host de un dominio específico.
     * Imprime la información en el formato solicitado:
     * Dirección IP, Nombre, <nombre>/<IP>, IP, <nombre>/<IP>
     *
     * @param dominio el nombre de dominio o IP a resolver.
     */
    private static void mostrarDireccionDeDominio(String dominio) {
        try {
            InetAddress address = InetAddress.getByName(dominio);

            String ip = address.getHostAddress();
            String nombre = address.getHostName();

            System.out.println("Dirección IP: " + ip);
            System.out.println("Nombre: " + nombre);
            System.out.println(nombre + "/" + ip);
            System.out.println(ip);
            System.out.println(nombre + "/" + ip);

        } catch (UnknownHostException e) {
            System.err.println("No se pudo resolver la dirección: " + dominio);
        }
    }

    /**
     * Muestra las direcciones IP locales del equipo.
     * Incluye la IP principal, el nombre del host y todas las direcciones
     * asociadas a las interfaces de red locales.
     *
     * Formato de salida:
     * Dirección IP, Nombre, <nombre>/<IP>, IP, <nombre>/<IP>, <nombre>/<otras IPs>
     */
    private static void mostrarDireccionesLocales() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            String nombre = localHost.getHostName();
            String ip = localHost.getHostAddress();

            // Primer bloque con la IP principal
            System.out.println("Dirección IP: " + ip);
            System.out.println("Nombre: " + nombre);
            System.out.println(nombre + "/" + ip);
            System.out.println(ip);
            System.out.println(nombre + "/" + ip);

            // Listar todas las interfaces de red y sus direcciones
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                Enumeration<InetAddress> direcciones = ni.getInetAddresses();

                while (direcciones.hasMoreElements()) {
                    InetAddress addr = direcciones.nextElement();
                    System.out.println(nombre + "/" + addr.getHostAddress());
                }
            }

        } catch (UnknownHostException | SocketException e) {
            System.err.println("No se pudieron obtener las direcciones locales: " + e.getMessage());
        }
    }
}
