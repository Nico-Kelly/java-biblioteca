import static org.junit.Assert.*;
import org.junit.Test;

public class RevistaTest {

    @Test
    public void revistaTieneComportamientoEsperado() {
        Revista revista = new Revista(
            "Ciencia Hoy",
            2023,
            45,
            1
        );

        assertEquals("Ciencia Hoy", revista.titulo());
        assertEquals(45, revista.numero());

        assertEquals(7, revista.diasPrestamo());

        revista.prestar();

        assertFalse(revista.estaDisponible());

        revista.devolver();

        assertTrue(revista.estaDisponible());
    }
}