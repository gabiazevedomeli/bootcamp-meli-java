package praticaintegradoradois;

public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double calcular(int quantidadeDeProdutos) {
        double calculaPrecoTotal = this.preco * quantidadeDeProdutos;
        return calculaPrecoTotal;
    }

    @Override
    public String toString() {
        return "Teste";
    }
}