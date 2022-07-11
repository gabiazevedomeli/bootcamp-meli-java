package praticaintegradoraum.classes;

import java.util.ArrayList;
import java.util.List;

public class Corrida {
    private Double distancia;
    private Double premioEmDolares;
    private String nome;
    private Integer numeroVeiculosPermitidos;
    private List<Veiculo> listaVeiculos;

    public Corrida() {}

    public Corrida(Double distancia, Double premioEmDolares, String nome, Integer numeroVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.numeroVeiculosPermitidos = numeroVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        if (numeroVeiculosPermitidos > listaVeiculos.size()) {
            if (!listaVeiculos.contains(carro)) {
                listaVeiculos.add(carro);
                System.out.println("O carro de placa: " + carro.getPlaca() + " foi incluído à corrida!");
            } else {
                System.out.println("Carro: " + carro.getPlaca() + " já está participando da corrida!");
            }
        } else {
            System.out.println("Corrida lotada! O carro: " + carro.getPlaca() + " não poderá participar!!!" );
        }
    }

    public void adicionarMoto(Moto moto) {
        if (numeroVeiculosPermitidos > listaVeiculos.size()) {
            if (!listaVeiculos.contains(moto)) {
                listaVeiculos.add(moto);
                System.out.println("A moto de placa: " + moto.getPlaca() + " foi incluída à corrida!");
            } else {
                System.out.println("Moto: " + moto.getPlaca() + " já está participando da corrida!");
            }
        } else {
            System.out.println("Corrida lotada! A moto: " + moto.getPlaca() + " não poderá participar!!!" );
        }
    }

    public void deletaVeiculo(Veiculo veiculo) {
        if (listaVeiculos.remove(veiculo)) {
            System.out.println("O veículo " + veiculo.getPlaca() + " foi removido da corrida");
        } else {
            System.out.println("Este veículo: " + veiculo.getPlaca() + " não está inscrito na corrida!!!");
        }
    }

    public void deletaVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) { // fazendo a comparação entre placas
                listaVeiculos.remove(veiculo); // se o boolean do bloco if for true, o veículo será removido da lista
                System.out.println("O veículo da placa: " + veiculo.getPlaca() + " foi removido da corrida!!!");
            } else {
                System.out.println("Veículo " + placa + " não estava na corrida!!!");
            }
        }
    }

    public Double calcularDesempenho(Veiculo veiculo) {
        return veiculo.getVelocidade() * 1 / 2 * veiculo.getAceleracao() / (veiculo.getAnguloGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100));
    }

    public Veiculo definirVencedor() {
        Veiculo veiculoVencedor = null;
        if (!listaVeiculos.isEmpty()) {
            Double melhorDesempenho = 0.0;
            for (Veiculo veiculo : listaVeiculos) {
                if (melhorDesempenho < calcularDesempenho(veiculo)) {
                    melhorDesempenho = calcularDesempenho(veiculo);
                    veiculoVencedor = veiculo;
                }
            }
        }
        return veiculoVencedor;
    }

    public void mostrarTodosOsVeiculos() {
        listaVeiculos.stream()
                .forEach(System.out::println);
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEmDolares() {
        return premioEmDolares;
    }

    public void setPremioEmDolares(Double premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public void setNomeVencedor(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroVeiculosPermitidos() {
        return numeroVeiculosPermitidos;
    }

    public void setNumeroVeiculosPermitidos(Integer numeroVeiculosPermitidos) {
        this.numeroVeiculosPermitidos = numeroVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
}
