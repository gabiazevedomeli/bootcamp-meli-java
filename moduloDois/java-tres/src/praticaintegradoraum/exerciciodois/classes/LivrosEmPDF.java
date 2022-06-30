package praticaintegradoraum.exerciciodois.classes;

import praticaintegradoraum.exerciciodois.interfaces.Imprimir;

public class LivrosEmPDF implements Imprimir {
    private int numeroPaginas;
    private String nomeAutor;
    private String titulo;
    private String genero;

    public LivrosEmPDF(int numeroPaginas, String nomeAutor, String titulo, String genero) {
        this.numeroPaginas = numeroPaginas;
        this.nomeAutor = nomeAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimiDocumento(String tipoDocumento) {
        // implementação do método para esse caso
    }
}
