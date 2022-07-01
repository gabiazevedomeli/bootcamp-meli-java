package praticaintegradoraum.exerciciodois.classes;

public abstract class Documento {
    private String ID;

    public Documento(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "ID='" + ID + '\'' +
                '}';
    }
}
