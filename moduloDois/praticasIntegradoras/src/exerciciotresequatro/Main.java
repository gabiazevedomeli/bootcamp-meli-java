package exerciciotresequatro;

import exerciciodois.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoaConstrutorPadrao = new Pessoa();
        Pessoa pessoaConstrutorUm = new Pessoa("Gabriela Azevedo", 33, "123.456.789-00");
        Pessoa pessoaConstrutorDois = new Pessoa("Heitor Lima", 11, "890.654.321-99", 52.00, 1.57);
        Pessoa pessoaTestaConstrutor = new Pessoa("Ângela Maria", 67);
        // O objeto só será criado caso seja criado um construtor para aceitar apenas estes dois parâmetros, nome e idade.
        // Quando o construtor é criado o erro se extingue.

        System.out.println(pessoaConstrutorDois.calculaIMC(52, 1.80));
        System.out.println(pessoaConstrutorDois.toString());
        System.out.println(pessoaConstrutorDois.ehMaiorIdade(18));
    }
}

// teste
