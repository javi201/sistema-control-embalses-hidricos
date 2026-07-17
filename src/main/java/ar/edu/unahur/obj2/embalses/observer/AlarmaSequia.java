package ar.edu.unahur.obj2.embalses.observer;

import ar.edu.unahur.obj2.embalses.Embalse;

public class AlarmaSequia implements Observador {

    @Override
    public void actualizar(Embalse embalse) {
        if (embalse.getVolAguaActual() <= 0) {
            System.out.println(embalse.getIdentificador() + " con nivel debajo de 0!");
        }
    }

}
