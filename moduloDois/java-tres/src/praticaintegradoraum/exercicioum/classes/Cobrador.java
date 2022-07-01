package praticaintegradoraum.exercicioum.classes;

import praticaintegradoraum.exercicioum.interfaces.ConsultaSaldo;
import praticaintegradoraum.exercicioum.interfaces.SaqueDinheiro;

public class Cobrador extends ContaCliente implements SaqueDinheiro, ConsultaSaldo {

    public Cobrador(String nomeCliente, int numeroConta, double saldo) {
        super(nomeCliente, numeroConta, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println(this.getNomeCliente() + ", você tem " +
                this.saldo + " de saldo disponível.");
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo >= 0) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void transacaoOk(String tipoTransacao) {
        System.out.println("Transação " + tipoTransacao + " concluída com sucesso!");
    }

    @Override
    public void transacaoNaoOk(String tipoTransacao) {
        System.out.println("A transação " + tipoTransacao + " não pode ser finalizada!");
    }
}
