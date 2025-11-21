import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Actividad 5: Realiza una conexión HTTP a www.vitoria-gasteiz.com
 * utilizando HttpClient y muestra información del response.
 */
public class Actividad5 {

    /**
     * Método principal que llama al método VisualizarConexión.
     *
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        VisualizarConexión();
    }

    /**
     * Realiza la conexión HTTP y muestra la información del response.
     *
     * Crea un HttpClient, un HttpRequest con la URI de www.vitoria-gasteiz.com,
     * envía la solicitud y obtiene un HttpResponse<String>.
     * Se imprime:
     *  - toString() del objeto response
     *  - statusCode() de la respuesta
     *  - Content-Type de los encabezados
     */
    private static void VisualizarConexión() {
        try {
            URI uri = new URI("http://www.vitoria-gasteiz.com");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Conexión con www.vitoria-gasteiz.com");
            System.out.println("==========================");
            System.out.println("\tMétodo toString():" + response.toString());
            System.out.println("\tMétodo getStatusCode():" + response.statusCode());
            System.out.println("\tMétodo getContentType():" +
                    response.headers().firstValue("Content-Type").orElse("N/A"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
