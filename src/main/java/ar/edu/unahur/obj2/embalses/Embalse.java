package ar.edu.unahur.obj2.embalses;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;
import ar.edu.unahur.obj2.embalses.observer.Observador;

/**
 * Embalse
 */
public class Embalse {
    private Integer identificador;
    private Integer volAguaActual;

    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void notificarObservadores() {
        for(Observador obs : observadores) {
            obs.actualizar(this);
        }
    }

    public Embalse(Integer identificador, Integer volAguaActual) {
        this.identificador = identificador;
        this.volAguaActual = volAguaActual;
    }

    public Integer getIdentificador() {
        return this.identificador;
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
