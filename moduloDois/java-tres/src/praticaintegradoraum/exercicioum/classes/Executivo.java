package praticaintegradoraum.exercicioum.classes;

import praticaintegradoraum.exercicioum.interfaces.Deposito;
import praticaintegradoraum.exercicioum.interfaces.Transferencia;

public class Executivo extends ContaCliente implements Deposito, Transferencia {

    public Executivo(String nomeCliente, int numeroConta, double saldo) {
        super(nomeCliente, numeroConta, saldo);
    }

    @Override
    public void depositar(double valor) {
            this.saldo += valor;
            System.out.println("A quantia de: R$ " + valor + " foi depositada com sucesso na conta, "
                + this.getNumeroConta() + " do cliente, " + this.getNomeCliente());
    }

    @Override
    public void transacaoOk(String tipoTransacao) {
        System.out.println("Transação " + tipoTransacao + " concluída com sucesso!");
    }

    @Override
    public void transacaoNaoOk(String tipoTransacao) {
        System.out.println("A transação " + tipoTransacao + " não pode ser finalizada!");
    }

    @Override
    public void transferir(double valorTransferencia) {
        System.out.println("Transferência realizada com sucesso!");
    }
}
