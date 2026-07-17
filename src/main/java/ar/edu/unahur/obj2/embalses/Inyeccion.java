package ar.edu.unahur.obj2.embalses;

public class Inyeccion implements Comando {
    private Embalse embalse;
    private Integer volAdicional;

    public Inyeccion(Embalse embalse, Integer volAdicional) {
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
