import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.io.IOUtils;

public class Actividad1 {

    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String servidor = "ftp.rediris.es";
        String usuario = "anonymous";
        String password = "dm2";

        System.out.println("Nos conectamos a ftp.rediris.es");

        try {
            // Conexión al servidor FTP (puerto 21 por defecto)
            ftpClient.connect(servidor, 21);

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

            // Directorio actual tras el login
            String directorioActual = ftpClient.printWorkingDirectory();
            if (directorioActual == null) {
                directorioActual = "/";
            }
            System.out.println("Directorio actual:" + directorioActual);

            // Crear el directorio DM2PROS
            boolean creado = ftpClient.makeDirectory("DM2PROS");
            if (creado) {
                System.out.println("Directorio creado....");
            } else {
                System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
            }

            // Logout del servidor
            boolean logoutOk = ftpClient.logout();
            if (logoutOk) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer logout...");
            }

            // Desconexión final
            ftpClient.disconnect();
            System.out.println("Desconectado...");

        } catch (IOException e) {
            // Ejemplo de uso de commons-io: convertir el stacktrace a texto
            StringWriter sw = new StringWriter();
            e.printStackTrace(new java.io.PrintWriter(sw));
            String stackTraceComoTexto = sw.toString();
            // Aquí podrías guardar o mostrar el texto si quisieras
            // Por ejemplo, solo mostrar un mensaje resumido:
            System.err.println("Se ha producido un error de E/S en la conexión FTP.");

            // Cierre seguro de la conexión
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
