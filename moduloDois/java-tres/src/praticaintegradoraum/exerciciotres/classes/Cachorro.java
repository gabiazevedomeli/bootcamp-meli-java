package praticaintegradoraum.exerciciotres.classes;

import praticaintegradoraum.exerciciotres.interfaces.AminalCarnivoro;

public class Cachorro extends Animal implements AminalCarnivoro {
    private String gostoAlimentar;

    public Cachorro(String nome, String cor, String raca, String gostoAlimentar) {
        super(nome, cor, raca);
        this.gostoAlimentar = gostoAlimentar;
    }

    public String getGostoAlimentar() {
        return gostoAlimentar;
    }

    @Override
    public void emitirSom() {
        System.out.println("Eu sou um cachorro e meu som é o latido: AU AU AU !!!");
    }

    @Override
    public void comerCarne(String gostoAlimentar) {
        if (this.gostoAlimentar.equals(gostoAlimentar)) {
            System.out.println("Olá! Sou um cachorro e adoro ração de carne!!!\n");
        } else {
            System.out.println("Olá! Eu não sou carnívoro, pode ser que eu seja um ruminante... ");
        }
    }
}
