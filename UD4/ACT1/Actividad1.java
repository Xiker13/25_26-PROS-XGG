import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

/**
 * Clase principal que realiza una conexión FTP al servidor público de RedIRIS,
 * crea un directorio y finaliza la sesión mostrando los mensajes requeridos.
 *
 * @author Xiker
 * @version 1.0
 * @since 2026
 */
public class Actividad1 {

    /**
     * Método principal que ejecuta el programa.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        /**
         * Cliente FTP utilizado para realizar la conexión y las operaciones
         * sobre el servidor.
         */
        FTPClient ftpClient = new FTPClient();

        /**
         * Nombre del servidor FTP al que se va a conectar el programa.
         */
        String servidor = "ftp.rediris.es";

        /**
         * Usuario para acceder al servidor FTP.
         */
        String usuario = "anonymous";

        /**
         * Contraseña para acceder al servidor FTP.
         */
        String password = "dm2";

        System.out.println("Nos conectamos a " + servidor);

        try {
            /**
             * Establece la conexión con el servidor FTP.
             */
            ftpClient.connect(servidor);

            /**
             * Realiza el login en el servidor FTP con las credenciales indicadas.
             */
            boolean loginOk = ftpClient.login(usuario, password);

            if (!loginOk) {
                System.out.println("Login incorrecto...");
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                }
                System.out.println("Desconectado...");
                return;
            }

            System.out.println("Login correcto");

            /**
             * Obtiene y muestra el directorio de trabajo actual tras el login.
             */
            String directorioActual = ftpClient.printWorkingDirectory();
            System.out.println("Directorio actual:" + directorioActual);

            /**
             * Intenta crear el directorio DM2PROS en el servidor FTP.
             */
            boolean creado = ftpClient.makeDirectory("DM2PROS");
            if (creado) {
                System.out.println("Directorio creado....");
            } else {
                System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
            }

            /**
             * Realiza el logout del servidor FTP.
             */
            boolean logoutOk = ftpClient.logout();
            if (logoutOk) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer logout...");
            }

            /**
             * Desconecta el cliente FTP del servidor.
             */
            ftpClient.disconnect();
            System.out.println("Desconectado...");

        } catch (IOException e) {
            /**
             * Gestiona posibles errores de entrada/salida producidos durante
             * la conexión o las operaciones FTP.
             */
            System.err.println("Se ha producido un error de E/S en la conexión FTP.");

            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                System.err.println("Error al cerrar la conexión FTP.");
            }
        }
    }
}
