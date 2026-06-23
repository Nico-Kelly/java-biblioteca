import static org.junit.Assert.*;
import org.junit.Test;

public class LibroTest {

    @Test
    public void libroTieneComportamientoEsperado() {
        Libro libro = new Libro(
            "POO en Java",
            2024,
            "Ana Torres",
            1
        );

        assertEquals("POO en Java", libro.titulo());
        assertEquals(2024, libro.anio());
        assertEquals("Ana Torres", libro.autor());

        assertEquals(14, libro.diasPrestamo());

        assertTrue(libro.estaDisponible());

        libro.prestar();

        assertFalse(libro.estaDisponible());

        libro.devolver();

        assertTrue(libro.estaDisponible());
    }
}