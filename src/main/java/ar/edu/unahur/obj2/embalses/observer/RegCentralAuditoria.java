package ar.edu.unahur.obj2.embalses.observer;

import ar.edu.unahur.obj2.embalses.Embalse;

public class RegCentralAuditoria implements Observador {

    @Override
    public void actualizar(Embalse embalse) {
        System.out.println(embalse.getIdentificador() + " varió su volumen: " + embalse.getVolAguaActual());
    }

}
