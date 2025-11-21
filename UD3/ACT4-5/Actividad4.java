import java.net.URI;

/**
 * Actividad 4: Muestra las propiedades de varios objetos URI.
 *
 * Se crean tres URIs diferentes y se muestran sus propiedades:
 * host, puerto, path, scheme y authority.
 *
 * @author Xiker
 */
public class Actividad4 {

    /**
     * Método principal que crea los objetos URI y llama al método
     * Visualizar para cada uno de ellos.
     *
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        try {
            URI uri1 = new URI("http://docs.oracle.com");
            URI uri2 = new URI("http://docs.oracle.com/javase/7");
            URI uri3 = new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");

            Visualizar(uri1);
            Visualizar(uri2);
            Visualizar(uri3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra en consola las propiedades de un objeto URI.
     *
     * @param uri Objeto URI cuyos datos se desean mostrar
     */
    private static void Visualizar(URI uri) {
        System.out.println("URI: " + uri.toString());
        System.out.println("\tHost: " + uri.getHost());
        System.out.println("\tPort: " + uri.getPort());
        System.out.println("\tPath: " + uri.getPath());
        System.out.println("\tScheme: " + uri.getScheme());
        System.out.println("\tAuthority: " + uri.getAuthority());
    }
}
