package praticaintegradoraum.exercicioum.classes;

public class AppContaCliente {
    public static void main(String[] args) {

        System.out.println("------------ Executivo ------------");
        Executivo executivo = new Executivo("Marcos Alves", 0045, 1245.50);

        executivo.depositar(1000);
        executivo.transacaoOk("Depósito");
        executivo.transferir(2000);
        executivo.transacaoNaoOk("Transferência");

        System.out.println("------------ Básico ------------");
        Basico basico = new Basico("Daiana Marques", 3345, 345.90);

        basico.consultarSaldo();
        basico.transacaoOk("Consulta Saldo");
        basico.pagarServico("Contábil");
        basico.sacar(400);
        basico.transacaoNaoOk("Sacar");

        System.out.println("------------ Cobrador ------------");
        Cobrador cobrador = new Cobrador("Stanislau Sampaio", 9987, 3456.90);

        cobrador.sacar(200);
        cobrador.transacaoOk("Sacar");
        cobrador.consultarSaldo();
        cobrador.transacaoNaoOk("Consultar Saldo");

    }
}
