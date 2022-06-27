package praticaintegradoradois;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pereciveis extends Produto {
    private int diasParaVencer;

    // construtor da classe filha recebe os parâmetros da classe pai e os seus
    public Pereciveis(int diasParaVencer, String nome, double preco) {
        super(nome, preco); // super recebe os parâmetros herdados da superclasse
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return this.diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcular(int quantidadeDeProdutos) {
        double calculoPrecoTotal = getPreco() * quantidadeDeProdutos;
        BigDecimal formatPrecoTotal = new BigDecimal(calculoPrecoTotal).setScale(2, RoundingMode.HALF_EVEN);
        if (this.diasParaVencer == 1) return formatPrecoTotal.doubleValue()/4;
        if (this.diasParaVencer == 2) return formatPrecoTotal.doubleValue()/3;
        if (this.diasParaVencer == 3) return formatPrecoTotal.doubleValue()/2;
        return formatPrecoTotal.doubleValue();
    }

    @Override
    public String toString() {
        return "Pereciveis{" +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }
}
