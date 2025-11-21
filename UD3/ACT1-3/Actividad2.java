import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Actividad2
 *
 * Programa que recibe como parámetro un nombre de dominio o dirección IP
 * y obtiene todas las direcciones IP asociadas utilizando la clase InetAddress.
 *
 * Salida esperada:
 * - Si se pasa un dominio válido, imprime todas las IPs asociadas.
 * - Si no se pasa ningún parámetro, muestra un mensaje indicando que se necesita una URL.
 *
 * Ejemplo de ejecución:
 * java Actividad2 www.gencat.cat
 * Las direcciones asociadas a www.gencat.cat son:
 * www.gencat.cat/84.53.132.41
 * www.gencat.cat/84.53.132.18
 *
 * @author Xiker
 */
public class Actividad2 {

    /**
     * Método principal que ejecuta el programa.
     * Verifica si se ha pasado un parámetro, obtiene todas las direcciones
     * IP asociadas al dominio o IP proporcionada y las imprime en pantalla.
     *
     * @param args argumentos de línea de comandos; el primer argumento
     *             debe ser el nombre de dominio o dirección IP a consultar.
     */
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
