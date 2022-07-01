package praticaintegradoraum.exerciciodois.classes;

import java.util.List;

public class Curriculo extends Documento {
    private Pessoa pessoa;
    List<Habilidade> habilidades;

    public Curriculo(String ID, Pessoa pessoa, List<Habilidade> habilidades) {
        super(ID);
        this.pessoa = pessoa;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                "pessoa=" + pessoa +
                ", habilidades=" + habilidades +
                '}';
    }
}
