package praticaintegradoradois.garagem;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Garagem {
    private String cnpj;
    List<Veiculo> listaVeiculos;

    public Garagem(String cnpj, List<Veiculo> listaVeiculos) {
        this.cnpj = cnpj;
        this.listaVeiculos = listaVeiculos;
    }

    // aqui dentro da própria classe que contém o modelo de criação dos dados, criar também os métodos para manipulá-los

    // método para mostrar todos os carros
    public void exibeTodosOsCarros() {
        listaVeiculos.forEach(System.out::println);
    }

    // método para ordenar em ordem crescente
    public void ordenaCarrosPorPreco() {
        listaVeiculos.stream()
                .sorted((v1, v2) -> v1.getPreco().compareTo(v2.getPreco()))
                .forEach(System.out::println);
    }

    // método para ordenar por marca
    public void ordenaCarrosPorMarca() {
        listaVeiculos.stream()
                .sorted(Comparator.comparing(Veiculo::getMarca))
                .forEach(System.out::println);
    }

    // método para listar os carros com preço não superior a 1000
    public void listarPrecoCarrosMenoresQueMil() {
        listaVeiculos.stream()
                .filter(veiculo -> veiculo.getPreco() < 1000)
                .forEach(System.out::println);
    }

    // método para listar os carros com preço maiores ou iguais a 1000
    public void listarPrecoCarrosMaioresOuIguaisAMil() {
        listaVeiculos.stream()
                .filter(veiculo -> veiculo.getPreco() >= 1000)
                .forEach(System.out::println);
    }

    // método para fazer a média de preço de todos os carros
    public Double mediaPrecoCarros() {
        return somaPrecoVeiculos() / listaVeiculos.size();
    }

    public Double somaPrecoVeiculos() {
        Double total = 0.0;
        for (Veiculo veiculo : listaVeiculos) {
            total += veiculo.getPreco();
            total++;
        }
        return total;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Garagem{" +
                "cnpj='" + cnpj + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                '}';
    }
}
