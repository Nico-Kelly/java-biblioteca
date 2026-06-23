import static org.junit.Assert.*;
import org.junit.Test;

public class CursoCompletoTest {

    @Test
    public void cursoCalculaCostoLicencia() {
        CursoCompleto curso =
            new CursoCompleto(
                "Investigación I",
                2026,
                "Licencia UNP",
                1,
                180,
                5
            );

        assertEquals(
            11000,
            curso.costoLicencia(),
            0.01
        );
    }
}