package praticaintegradoraum.exerciciodois.classes;

import praticaintegradoraum.exerciciodois.interfaces.Imprimir;

public class Relatorios implements Imprimir {
    // texto de comprimento n
    private int numeroPaginas;
    private String autor;
    private String revisor;

    public Relatorios(int numeroPaginas, String autor, String revisor) {
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimiDocumento(String tipoDocumento) {
        // implementação do método para esse caso
    }
}
