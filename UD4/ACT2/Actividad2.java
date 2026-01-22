import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

/**
 * Clase principal que se conecta a un servidor FTP y crea
 * una estructura de directorios personalizada dentro del mismo.
 * El programa:
 *  - Se conecta a un servidor FTP.
 *  - Inicia sesión con un usuario y contraseña.
 *  - Muestra el directorio actual.
 *  - Crea un directorio principal con el apellido del alumno.
 *  - Dentro de él, crea tres subdirectorios: html, imagenes y css.
 *  - Cierra correctamente la sesión FTP.
 *
 * @author Xiker
 */
public class Actividad2 {

    public static void main(String[] args) {

        // Dirección IP del servidor FTP (contenedor Docker)
        String servidor = "127.0.0.1";

        // Credenciales de acceso al servidor FTP
        String usuario = "dinux";
        String password = "dinux";
        // String password = "1234"; // Contraseña alternativa para tu servidor personal

        // Primer apellido del alumno, usado para personalizar el nombre del directorio principal
        String apellido = "garcia_de_albeniz"; // Sustituido por tu apellido real

        // Nombre del directorio principal que se creará en el servidor FTP
        String dirPrincipal = "aplicacionweb" + apellido;

        // Creación del cliente FTP
        FTPClient ftp = new FTPClient();

        try {
            // Mensaje previo a la conexión
            System.out.println("Nos conectamos a " + servidor);

            // Conexión al servidor FTP
            ftp.connect(servidor);

            // Intento de inicio de sesión con las credenciales indicadas
            if (!ftp.login(usuario, password)) {
                System.out.println("Login incorrecto...");
                ftp.disconnect();
                return;
            }

            // Mensaje si el login es correcto
            System.out.println("Login correcto.");

            // Muestra del directorio actual en el servidor FTP
            System.out.println("Directorio actual: " + ftp.printWorkingDirectory());

            // Variable para controlar si todos los directorios se crean correctamente
            boolean creado = true;

            // Intento de creación del directorio principal
            if (!ftp.makeDirectory(dirPrincipal)) {
                creado = false;
            } else {
                // Si se crea correctamente, se accede a él
                ftp.changeWorkingDirectory(dirPrincipal);

                // Creación de los subdirectorios requeridos
                if (!ftp.makeDirectory("html")) creado = false;
                if (!ftp.makeDirectory("imagenes")) creado = false;
                if (!ftp.makeDirectory("css")) creado = false;
            }

            // Mensaje según el resultado de la creación de directorios
            if (creado) {
                System.out.println("Directorios creados...");
            } else {
                System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
            }

            // Cierre de sesión en el servidor FTP
            if (ftp.logout()) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer logout");
            }

            // Desconexión del servidor FTP
            ftp.disconnect();
            System.out.println("Desconectado...");

        } catch (IOException e) {
            // Captura y muestra de errores de comunicación FTP
            System.out.println("Error en la comunicación FTP: " + e.getMessage());
        }
    }
}
