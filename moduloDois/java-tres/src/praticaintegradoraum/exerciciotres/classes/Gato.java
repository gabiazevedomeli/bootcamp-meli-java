package praticaintegradoraum.exerciciotres.classes;

import praticaintegradoraum.exerciciotres.interfaces.AminalCarnivoro;

public class Gato extends Animal implements AminalCarnivoro {
    private String gostoAlimentar;

    public Gato(String nome, String cor, String raca, String gostoAlimentar) {
        super(nome, cor, raca);
        this.gostoAlimentar = gostoAlimentar;
    }

    public String getGostoAlimentar() {
        return gostoAlimentar;
    }

    @Override
    public void emitirSom() {
        System.out.println("Eu sou um gato e meu som é o miado: MIAU MIAU MIAU !!!");
    }

    @Override
    public void comerCarne(String gostoAlimentar) {
        if (this.gostoAlimentar.equals(gostoAlimentar)) {
            System.out.println("Olá! Sou um gato e adoro ração de carne!!!\n");
        } else {
            System.out.println("Olá! Eu não sou" + this.gostoAlimentar
                    + ", pode ser que eu seja " + gostoAlimentar + " ... ");
        }
    }
}
