package ar.edu.unahur.obj2.embalses.observer;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.embalses.Embalse;

public class ObservadorTest {
    private Embalse embalse;
    private RegCentralAuditoria regCentralAuditoria;
    private AlarmaSequia alarmaSequia;

    @Test
    void test() {
        embalse = new Embalse(2, 20);
        regCentralAuditoria = new RegCentralAuditoria();
        alarmaSequia = new AlarmaSequia();

        embalse.agregarObservador(alarmaSequia);
        embalse.agregarObservador(regCentralAuditoria);

        try {
            embalse.extraerAgua(30);
            
        }


    }
}
