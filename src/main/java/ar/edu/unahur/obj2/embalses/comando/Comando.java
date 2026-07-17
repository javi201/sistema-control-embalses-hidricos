package ar.edu.unahur.obj2.embalses.comando;

import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

public interface Comando {
    void ejecutar() throws NivelDeSequiCriticaException;
    void deshacer();
}
