package ar.edu.unahur.obj2.embalses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.embalses.comando.Comando;
import ar.edu.unahur.obj2.embalses.comando.Extraccion;
import ar.edu.unahur.obj2.embalses.comando.Historial;
import ar.edu.unahur.obj2.embalses.comando.Inyeccion;
import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

public class EmbalseTest {
    private Historial historial;
    private Embalse embalse;

    @Test
    void testExtraerAgua() {

    }

    @Test
    void testGetVolAguaActual() {

    }

    @Test
    void testInyectarAgua() {

    }

    @Test
    void testInyectar() throws NivelDeSequiCriticaException {
        historial = new Historial();
        embalse = new Embalse(1, 100);

        Comando inyectar = new Inyeccion(embalse, 20);
        historial.ejecutarComando(inyectar);

        assertEquals(120, embalse.getVolAguaActual());
    }

    @Test
    void testInyectarYDeshacer() throws NivelDeSequiCriticaException {
        historial = new Historial();
        embalse = new Embalse(1, 100);

        Comando extraccion = new Extraccion(embalse, 20);
        historial.ejecutarComando(extraccion);
        historial.deshacer();

        assertEquals(100, embalse.getVolAguaActual());
    }
}
