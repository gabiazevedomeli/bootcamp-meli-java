package praticaintegradoraum.exerciciodois.classes;

public class Habilidade {
    private String descricaoHabilidades;

    public Habilidade(String descricaoHabilidades) {
        this.descricaoHabilidades = descricaoHabilidades;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                "descricaoHabilidades='" + descricaoHabilidades + '\'' +
                '}';
    }
}
