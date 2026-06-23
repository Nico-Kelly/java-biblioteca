import static org.junit.Assert.*;
import org.junit.Test;

public class SolicitudTest {

    @Test
    public void solicitudPuedeProcesarse() {
        Usuario usuario =
            new Usuario("Ana", "123");

        Libro libro =
            new Libro(
                "POO",
                2024,
                "Autor",
                1
            );

        Solicitud solicitud =
            new Solicitud(usuario, libro);

        assertTrue(
            solicitud.puedeProcesarse()
        );
    }

    @Test
    public void solicitudNoPuedeProcesarse() {
        Usuario usuario =
            new Usuario("Ana", "123");

        Libro libro =
            new Libro(
                "POO",
                2024,
                "Autor",
                0
            );

        Solicitud solicitud =
            new Solicitud(usuario, libro);

        assertFalse(
            solicitud.puedeProcesarse()
        );
    }
}