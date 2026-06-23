import static org.junit.Assert.*;
import org.junit.Test;

public class PrestamoTest {

    @Test
    public void prestamoGuardaInformacion() {

        Usuario usuario =
            new Usuario("Ana", "123");

        Libro libro =
            new Libro(
                "POO",
                2024,
                "Autor",
                1
            );

        Prestamo prestamo =
            new Prestamo(usuario, libro);

        assertTrue(
            prestamo.usuario() == usuario
        );

        assertTrue(
            prestamo.material() == libro
        );

        assertEquals(
            14,
            prestamo.dias()
        );
    }
}