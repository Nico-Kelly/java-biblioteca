import static org.junit.Assert.*;
import org.junit.Test;

public class EbookTest {

    @Test
    public void ebookCalculaCostoLicencia() {
        Ebook ebook = new Ebook(
            "Algoritmos",
            2026,
            "Licencia UNP",
            2,
            300
        );

        assertEquals(
            2500,
            ebook.costoLicencia(),
            0.01
        );
    }

    @Test
    public void ebookAdministraLicencias() {
        Ebook ebook = new Ebook(
            "Algoritmos",
            2026,
            "Licencia UNP",
            1,
            300
        );

        assertTrue(ebook.estaDisponible());

        ebook.prestar();

        assertFalse(ebook.estaDisponible());

        ebook.devolver();

        assertTrue(ebook.estaDisponible());
    }
}