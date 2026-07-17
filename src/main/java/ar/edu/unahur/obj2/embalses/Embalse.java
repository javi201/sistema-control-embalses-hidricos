package ar.edu.unahur.obj2.embalses;

import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

/**
 * Embalse
 */
public class Embalse {
    private Integer identificador;
    private Integer volAguaActual;

    public Embalse(Integer identificador, Integer volAguaActual) {
        this.identificador = identificador;
        this.volAguaActual = volAguaActual;
    }

    public Integer getVolAguaActual() {
        return this.volAguaActual;
    }

    public void inyectarAgua(Integer volAdicional) {
        this.volAguaActual += volAdicional;
    }

    public void extraerAgua(Integer volARestar) throws NivelDeSequiCriticaException {
        if(this.volAguaActual - volARestar < -50) {
            throw new NivelDeSequiCriticaException("El volumen estaría por debajo de -50 hm3");
        }
        this.volAguaActual -= volARestar;
    }
}
