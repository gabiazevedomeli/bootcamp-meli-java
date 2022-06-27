package praticaintegradoradois;

public class Distribuidora {

    public static void main(String[] args) {
        Produto produtos[] = new Produto[5];
        produtos[0] = new Pereciveis(1, "Alcatra Bovina", 35.90);
        produtos[1] = new Pereciveis(4, "Iogurte Grego", 9.99);
        produtos[2] = new NaoPereciveis("mercearia", "Feijão Caldo Marrom", 8.90);
        produtos[3] = new NaoPereciveis("mercearia", "Trakinas", 3.69);
        produtos[4] = new Pereciveis(1, "Requeijão Cremoso Poços de Caldas", 5.99);

        int index = 0;
        while (index < produtos.length) {
            System.out.println("O produto: " + produtos[index].getNome()
                + " custa, " + produtos[index].calcular(5) + " reais.");
            index++;
        }
    }
}
