package praticaintegradoraum.exerciciodois.interfaces;

import praticaintegradoraum.exerciciodois.classes.Documento;

public interface Imprimir {
    public static void imprimeDocumento(Documento tipoDocumento) {
        System.out.println(tipoDocumento.toString());
    };
}
