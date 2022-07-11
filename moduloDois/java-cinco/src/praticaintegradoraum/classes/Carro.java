package praticaintegradoraum.classes;

public class Carro extends Veiculo {
    private static final Double PESO_CARRO = 1000.00;
    private static final Integer QUANT_RODAS = 4;

    public Carro(Double velocidade, Double aceleracao, Double anguloGiro, String placa) {
        super(velocidade, aceleracao, anguloGiro, placa, PESO_CARRO, QUANT_RODAS);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
