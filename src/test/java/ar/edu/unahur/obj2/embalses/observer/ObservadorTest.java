package ar.edu.unahur.obj2.embalses.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.embalses.Embalse;
import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

public class ObservadorTest {
    private Embalse embalse;
    private RegCentralAuditoria regCentralAuditoria;
    private AlarmaSequia alarmaSequia;

    @Test
    void testNoLanzarExcepcion() {
        embalse = new Embalse(2, 100);
        regCentralAuditoria = new RegCentralAuditoria();
        alarmaSequia = new AlarmaSequia();

        embalse.agregarObservador(alarmaSequia);
        embalse.agregarObservador(regCentralAuditoria);

        try {
            embalse.extraerAgua(10);
            assertEquals(90, embalse.getVolAguaActual());
        } catch (NivelDeSequiCriticaException e) {
            fail("Prueba");
        }


    }
}
