package praticaintegradoradois.garagem;

import java.util.ArrayList;
import java.util.List;

public class AppGaragem {
    public static void main(String[] args) {

        List<Veiculo> listaVeiculos = new ArrayList<>();

        listaVeiculos.add(new Veiculo("Ford", "Fiesta", 1000.00));
        listaVeiculos.add(new Veiculo("Ford", "Focus", 1200.00));
        listaVeiculos.add(new Veiculo("Ford", "Explore", 2500.00));
        listaVeiculos.add(new Veiculo("Fiat", "Uno", 500.00));
        listaVeiculos.add(new Veiculo("Fiat", "Cronos", 1000.00));
        listaVeiculos.add(new Veiculo("Fiat", "Torino", 1250.00));
        listaVeiculos.add(new Veiculo("Chevrolet", "Aveo", 1250.00));
        listaVeiculos.add(new Veiculo("Chevrolet", "Spin", 2500.00));
        listaVeiculos.add(new Veiculo("Toyota", "Corola", 1200.00));
        listaVeiculos.add(new Veiculo("Toyota", "Fortuner", 3000.00));
        listaVeiculos.add(new Veiculo("Renault", "Logan", 950.00));

        Garagem garagem = new Garagem("26.950.321/0001-01", listaVeiculos);

        System.out.println("Exibe todos os carros");
        garagem.exibeTodosOsCarros();

        System.out.println("\nExibe os carros com preço maior ou igual a 1000.00");
        garagem.listarPrecoCarrosMaioresOuIguaisAMil();

        System.out.println("\nExibe os carros com preço menor que 1000.00");
        garagem.listarPrecoCarrosMenoresQueMil();

        System.out.printf("\n A média de preço por carro é de: R$ %.2f \n", garagem.mediaPrecoCarros());

        System.out.println("\nExibe os carros ordenados por marca");
        garagem.ordenaCarrosPorMarca();

        System.out.println("\nExibe os carros ordenados por preço em ordem crescente");
        garagem.ordenaCarrosPorPreco();


    }
}
