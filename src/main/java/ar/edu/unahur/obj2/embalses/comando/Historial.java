package ar.edu.unahur.obj2.embalses.comando;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.embalses.excepciones.NivelDeSequiCriticaException;

public class Historial {
    private List<Comando> historial = new ArrayList<>();

    public void ejecutarComando(Comando comando) throws NivelDeSequiCriticaException {
        comando.ejecutar();
        historial.add(comando);
    }

    public void deshacer() {
        Integer tamLista = historial.size();

        if(tamLista != 0) {
            Integer ultimoIndice = tamLista - 1;
            Comando com = historial.get(ultimoIndice);
            historial.removeLast();

            com.deshacer();
        } else {
            System.out.println("No hay operaciones para deshacer");
        }
    }
}
