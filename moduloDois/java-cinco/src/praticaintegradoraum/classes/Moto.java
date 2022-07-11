package praticaintegradoraum.classes;

public class Moto extends Veiculo {
    private static final Double PESO_MOTO = 300.00;
    private static final Integer QUANT_RODAS = 2;

    public Moto() {
    }

    public Moto(Double velocidade, Double aceleracao, Double anguloGiro, String placa) {
        super(velocidade, aceleracao, anguloGiro, placa, PESO_MOTO, QUANT_RODAS);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
