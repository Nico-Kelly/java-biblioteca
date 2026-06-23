import static org.junit.Assert.*;
import org.junit.Test;

public class TesisTest {

    @Test
    public void tesisTieneComportamientoEsperado() {
        Tesis tesis = new Tesis(
            "Objetos y Aprendizaje",
            2022,
            "Licenciatura en Informática",
            1
        );

        assertEquals(
            "Licenciatura en Informática",
            tesis.carrera()
        );

        assertEquals(21, tesis.diasPrestamo());

        tesis.prestar();

        assertFalse(tesis.estaDisponible());

        tesis.devolver();

        assertTrue(tesis.estaDisponible());
    }
}