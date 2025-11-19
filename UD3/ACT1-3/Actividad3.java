import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {

    public static void main(String[] args) {

        // Si no se pasa ningún parámetro
        if (args.length == 0) {



            return;
        }

        String dato = args[0];

        try {
            // Obtener información a partir del dato introducido
            InetAddress address = InetAddress.getByName(dato);

            String nombre = address.getHostName();
            String ip = address.getHostAddress();

            // Mostrar en el formato solicitado
            System.out.println("Dirección IP: " + ip);
            System.out.println("Nombre: " + nombre);
            System.out.println(nombre + "/" + ip);
            System.out.println(ip);
            System.out.println(nombre + "/" + ip);

        } catch (UnknownHostException e) {
            System.err.println("No se pudo resolver: " + dato);
        }
    }
}
