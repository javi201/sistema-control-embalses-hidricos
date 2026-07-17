package ar.edu.unahur.obj2.embalses.comando;

import ar.edu.unahur.obj2.embalses.Embalse;
import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

public class Extraccion implements Comando {
    private Embalse embalse;
    private Integer volARestar;

    public Extraccion(Embalse embalse, Integer volARestar) {
        this.embalse = embalse;
        this.volARestar = volARestar;
    }

    @Override
    public void ejecutar() throws NivelDeSequiCriticaException {
        embalse.extraerAgua(volARestar);
    }

    @Override
    public void deshacer() {
        embalse.inyectarAgua(volARestar);
    }
}
