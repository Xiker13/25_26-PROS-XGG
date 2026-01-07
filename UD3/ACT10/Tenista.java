import java.io.Serializable;

/**
 * Clase que representa a un tenista.
 * <p>
 * Esta clase se utiliza para el envío de objetos a través de sockets UDP,
 * por lo que implementa la interfaz {@link Serializable}.
 * </p>
 *
 * Dispone de dos atributos:
 * <ul>
 *     <li>apellido: apellido del tenista</li>
 *     <li>altura: altura del tenista en centímetros</li>
 * </ul>
 *
 * @author Xiker
 */
public class Tenista implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Apellido del tenista */
    private String apellido;

    /** Altura del tenista en centímetros */
    private int altura;

    /**
     * Constructor que inicializa los atributos del tenista.
     *
     * @param apellido apellido del tenista
     * @param altura altura del tenista en centímetros
     */
    public Tenista(String apellido, int altura) {
        this.apellido = apellido;
        this.altura = altura;
    }

    /**
     * Devuelve el apellido del tenista.
     *
     * @return apellido del tenista
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Devuelve la altura del tenista.
     *
     * @return altura del tenista en centímetros
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Modifica el apellido del tenista.
     *
     * @param apellido nuevo apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Modifica la altura del tenista.
     *
     * @param altura nueva altura en centímetros
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
}
