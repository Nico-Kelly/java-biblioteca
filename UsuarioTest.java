import static org.junit.Assert.*;
import org.junit.Test;

public class UsuarioTest {

    @Test
    public void usuarioGuardaNombreYLegajo() {
        Usuario usuario = new Usuario("Ana", "123");

        assertEquals("Ana", usuario.nombre());
        assertEquals("123", usuario.legajo());
    }
}