package ar.edu.unahur.obj2.embalses.comando;

import ar.edu.unahur.obj2.embalses.Embalse;
import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;
import ar.edu.unahur.obj2.embalses.excepciones.ValoresInvalidosException;

public class Inyeccion implements Comando {
    private Embalse embalse;
    private Integer volAdicional;

    public Inyeccion(Embalse embalse, Integer volAdicional) {
        if(volAdicional <= 0)
            throw new ValoresInvalidosException("El volumen a agregar debe ser mayor a 0");

        this.embalse = embalse;
        this.volAdicional = volAdicional;
    }

    @Override
    public void ejecutar() {
        embalse.inyectarAgua(volAdicional);
    }

    @Override
    public void deshacer() {
        try {
            embalse.extraerAgua(volAdicional);
        }
        catch (NivelDeSequiCriticaException e) {

        }
    }

}
