import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class BibliotecaTest {

    @Test
    public void agregarUsuariosYMateriales() {
        Biblioteca biblioteca = new Biblioteca();

        Usuario ana = new Usuario("Ana", "123");
        Libro libro = new Libro("POO en Java", 2024, "Ana Torres", 2);

        biblioteca.agregarUsuario(ana);
        biblioteca.agregarMaterial(libro);

        assertEquals(1, biblioteca.cantidadDeUsuarios());
        assertEquals(1, biblioteca.cantidadDeMateriales());
    }

    @Test
    public void procesarSolicitudDisponibleGeneraPrestamo() {
        Biblioteca biblioteca = new Biblioteca();

        Usuario ana = new Usuario("Ana", "123");
        Libro libro = new Libro("POO en Java", 2024, "Ana Torres", 1);

        biblioteca.agregarUsuario(ana);
        biblioteca.agregarMaterial(libro);

        biblioteca.solicitarPrestamo(ana, libro);

        assertEquals(1, biblioteca.cantidadDeSolicitudesPendientes());

        boolean procesada = biblioteca.procesarSiguienteSolicitud();

        assertTrue(procesada);
        assertEquals(0, biblioteca.cantidadDeSolicitudesPendientes());
        assertEquals(1, biblioteca.cantidadDePrestamosActivos());
        assertFalse(libro.estaDisponible());

        ArrayList<Prestamo> prestamos = biblioteca.prestamosDe(ana);
        assertEquals(1, prestamos.size());
        assertTrue(prestamos.get(0).material() == libro);
    }

    @Test
    public void procesarSolicitudNoDisponibleGeneraReserva() {
        Biblioteca biblioteca = new Biblioteca();

        Usuario ana = new Usuario("Ana", "123");
        Ebook ebook = new Ebook("Algoritmos", 2026, "Licencia UNP", 0, 300);

        biblioteca.agregarUsuario(ana);
        biblioteca.agregarMaterial(ebook);

        biblioteca.solicitarPrestamo(ana, ebook);

        boolean procesada = biblioteca.procesarSiguienteSolicitud();

        assertFalse(procesada);
        assertEquals(0, biblioteca.cantidadDePrestamosActivos());
        assertTrue(ebook.tieneReservas());
        assertEquals(1, ebook.cantidadDeReservas());
        assertTrue(ebook.proximoUsuarioEnReserva() == ana);

        ArrayList<Reserva> reservas = biblioteca.reservasDe(ana);
        assertEquals(1, reservas.size());
        assertTrue(reservas.get(0).material() == ebook);
    }

    @Test
    public void costoTotalLicenciasSumaSoloRecursosDigitales() {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro = new Libro("POO en Java", 2024, "Ana Torres", 1);
        Ebook ebook = new Ebook("Algoritmos", 2026, "Licencia UNP", 2, 300);
        Audiolibro audiolibro = new Audiolibro("Historia de la computación", 2025, "Licencia UNP", 1, 60);
        CursoCompleto curso = new CursoCompleto("Investigación I", 2026, "Licencia UNP", 1, 180, 5);

        biblioteca.agregarMaterial(libro);
        biblioteca.agregarMaterial(ebook);
        biblioteca.agregarMaterial(audiolibro);
        biblioteca.agregarMaterial(curso);

        /*
         * Libro: 0
         * Ebook: 1000 + 300 * 5 = 2500
         * Audiolibro: 1500 + 60 * 10 = 2100
         * CursoCompleto: 5000 + 5 * 1200 = 11000
         * Total: 15600
         */

        assertEquals(15600, biblioteca.costoTotalLicencias(), 0.01);
    }

    @Test
    public void recursoDigitalDisminuyeYRecuperaLicencias() {
        Ebook ebook = new Ebook("Algoritmos", 2026, "Licencia UNP", 1, 300);

        assertTrue(ebook.estaDisponible());

        ebook.prestar();

        assertFalse(ebook.estaDisponible());

        ebook.devolver();

        assertTrue(ebook.estaDisponible());
    }

    @Test
    public void prestamosDeUnUsuarioDevuelveSoloSusPrestamos() {
        Biblioteca biblioteca = new Biblioteca();

        Usuario ana = new Usuario("Ana", "123");
        Usuario juan = new Usuario("Juan", "456");

        Libro libro = new Libro("POO en Java", 2024, "Ana Torres", 1);
        Revista revista = new Revista("Ciencia Hoy", 2023, 45, 1);

        biblioteca.agregarUsuario(ana);
        biblioteca.agregarUsuario(juan);
        biblioteca.agregarMaterial(libro);
        biblioteca.agregarMaterial(revista);

        biblioteca.solicitarPrestamo(ana, libro);
        biblioteca.solicitarPrestamo(juan, revista);

        biblioteca.procesarSiguienteSolicitud();
        biblioteca.procesarSiguienteSolicitud();

        assertEquals(1, biblioteca.prestamosDe(ana).size());
        assertEquals(1, biblioteca.prestamosDe(juan).size());

        assertTrue(biblioteca.materialesPrestadosA(ana).get(0) == libro);
        assertTrue(biblioteca.materialesPrestadosA(juan).get(0) == revista);
    }
}