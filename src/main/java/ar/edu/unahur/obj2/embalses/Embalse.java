package ar.edu.unahur.obj2.embalses;

/**
 * Embalse
 */
public class Embalse {
    private Integer identificador;
    private Integer volAguaActual;

    public Integer getVolAguaActual() {
        return this.volAguaActual;
    }

    public void inyectarAgua(Integer volAdicional) {
        this.volAguaActual += volAdicional;
    }

    public void extraerAgua(Integer volARestar) {
        this.volAguaActual -= volARestar;
    }
}
