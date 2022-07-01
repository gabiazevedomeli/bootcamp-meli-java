package praticaintegradoraum.exerciciotres.classes;

public class AppAnimais {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Roma", "Branca", "SRD", "Carnívoro");
        Gato gato = new Gato("Jeremias", "Malhado - Amarelo/Branco", "SRD", "Carnívoro");
        Vaca vaca = new Vaca("Fifi", "Malhada - Preto/Branca", "Gir", "Herbívora");

        System.out.println("------------ CACHORRO ------------\n");
        cachorro.emitirSom();
        cachorro.comerCarne("Carnívoro");

        System.out.println("------------ GATO ------------\n");
        gato.emitirSom();
        gato.comerCarne("Carnívoro");

        System.out.println("------------ VACA ------------\n");
        vaca.emitirSom();
        vaca.comerPasto("Herbívora");
    }
}
