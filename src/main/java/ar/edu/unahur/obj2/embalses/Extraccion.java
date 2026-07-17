package ar.edu.unahur.obj2.embalses;

public class Extraccion implements Comando {
    private Embalse embalse;
    private Integer volARestar;

    public Extraccion(Embalse embalse, Integer volARestar) {
        this.embalse = embalse;
        this.volARestar = volARestar;
    }

    @Override
    public void ejecutar() {
        embalse.extraerAgua(volARestar);
    }

    @Override
    public void deshacer() {
        embalse.inyectarAgua(volARestar);
    }
}
