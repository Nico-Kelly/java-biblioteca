import static org.junit.Assert.*;
import org.junit.Test;

public class AudiolibroTest {

    @Test
    public void audiolibroCalculaCostoLicencia() {
        Audiolibro audiolibro =
            new Audiolibro(
                "Historia",
                2025,
                "Licencia UNP",
                1,
                60
            );

        assertEquals(
            2100,
            audiolibro.costoLicencia(),
            0.01
        );
    }
}