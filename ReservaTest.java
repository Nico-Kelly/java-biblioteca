import static org.junit.Assert.*;
import org.junit.Test;

public class ReservaTest {

    @Test
    public void reservaGuardaUsuarioYMaterial() {

        Usuario usuario =
            new Usuario("Ana", "123");

        Libro libro =
            new Libro(
                "POO",
                2024,
                "Autor",
                1
            );

        Reserva reserva =
            new Reserva(usuario, libro);

        assertTrue(
            reserva.usuario() == usuario
        );

        assertTrue(
            reserva.material() == libro
        );
    }
}