package praticaintegradoraum.exerciciotres.classes;

import praticaintegradoraum.exerciciotres.interfaces.AnimalHerbivoro;

public class Vaca extends Animal implements AnimalHerbivoro {
    private String gostoAlimentar;

    public Vaca(String nome, String cor, String raca, String gostoAlimentar) {
        super(nome, cor, raca);
        this.gostoAlimentar = gostoAlimentar;
    }

    public String getGostoAlimentar() {
        return gostoAlimentar;
    }

    @Override
    public void emitirSom() {
        System.out.println("Eu sou uma vaca e meu som é o mugido: MU MU MU !!!");
    }

    @Override
    public void comerPasto(String gostoAlimentar) {
        if (this.gostoAlimentar.equals(gostoAlimentar)) {
            System.out.println("Olá! Sou uma vaca e adoro pastar!!!\n");
        } else {
            System.out.println("Olá! Eu não sou" + this.gostoAlimentar
                    + ", pode ser que eu seja " + gostoAlimentar + " ... ");
        }
    }
}
