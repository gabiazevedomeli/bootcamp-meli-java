package praticaintegradoraum;

import praticaintegradoraum.classes.Carro;
import praticaintegradoraum.classes.Corrida;
import praticaintegradoraum.classes.Veiculo;

public class AppCorridaDakar {
    public static void main(String[] args) {
        Corrida corridaMaluca = new Corrida(78.00, 120000.00, "Corrida Maluca" , 5);

        Carro carroDoMuttley = new Carro(60.00, 10.00, 45.00, "MUTTLEY_CAR");
        Carro carroDoDickVigarista = new Carro(120.00, 15.00, 40.00, "DICK_VIGARISTA_CAR");
        Carro carroDaPenelopeCharmosa = new Carro(200.00, 20.00, 50.00, "PENELOPE_CHARMOSA_CAR");
        Carro carroDoRingDing = new Carro(100.00, 30.00, 23.90, "RING_DING_CAR");
        Carro carroDoRufus = new Carro(110.00, 32.00, 43.00, "RUFUS_CAR");

        corridaMaluca.adicionarCarro(carroDoMuttley);
        corridaMaluca.adicionarCarro(carroDoDickVigarista);
        corridaMaluca.adicionarCarro(carroDaPenelopeCharmosa);
        corridaMaluca.adicionarCarro(carroDoRingDing);
        corridaMaluca.adicionarCarro(carroDoRufus);

        Veiculo veiculo = corridaMaluca.definirVencedor();
        System.out.println("O vencedor " + veiculo.getPlaca() + " leva " + corridaMaluca.getPremioEmDolares() + " dólares");

        corridaMaluca.deletaVeiculo(carroDoDickVigarista);

        corridaMaluca.mostrarTodosOsVeiculos();

        corridaMaluca.deletaVeiculoPorPlaca("RUFUS_CAR");

        corridaMaluca.mostrarTodosOsVeiculos();
    }
}
