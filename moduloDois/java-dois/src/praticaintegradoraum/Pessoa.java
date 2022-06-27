package praticaintegradoraum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pessoa {
    String nome;
    int idade;
    String id;
    double peso;
    double altura;

    public Pessoa() {
        // construtor padrão da classe que é chamado implicitamente quando instanciamos um objeto e não passamos nenhum parâmetro.
    }

    public Pessoa(String nome, int idade, String id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        // construtor recebendo 3 parâmetros da classe Pessoa
    }

    public Pessoa(String nome, int idade, String id, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        // construtor recebendo todos os parâmetros da classe Pessoa
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int calculaIMC(double pesoPessoa, double alturaPessoa) {
        double calculoIMC = peso / (Math.pow(alturaPessoa, 2));
        // https://www.devmedia.com.br/arredondando-numeros-em-java/28248
        BigDecimal formatIMC = new BigDecimal(calculoIMC).setScale(2, RoundingMode.HALF_EVEN);
        if (calculoIMC < 20) {
            System.out.println(this.nome + " está abaixo do peso, com IMC de: " + formatIMC.doubleValue());
            return -1;
        }
        if (calculoIMC > 20 && calculoIMC < 25) {
            System.out.println(this.nome + " possui peso saudável, com IMC de: " + formatIMC.doubleValue());
            return 0;
        }
        if (calculoIMC > 25) {
            System.out.println(this.nome + " está com sobrepeso, com IMC de: " + formatIMC.doubleValue());
            return 1;
        }
        return (int) calculoIMC;
    }

    public boolean ehMaiorIdade(int idadePessoa) {
        // retorna um valor booleano para a pergunta: É maior de idade?
        if (idadePessoa > 18) {
            System.out.println(this.nome + " é maior de idade!!!");
        } else {
            System.out.println(this.nome + " é menor de idade!!!");
        }
        return idadePessoa > 18;
    }

    @Override
    public String toString() {
        // https://www.devmedia.com.br/como-criar-sobreposicoes-usando-o-metodo-tostring-em-java/29042
        return "A pessoa: " + this.nome + " de ID " + this.id + " tem " + this.idade + " anos, pesa "
                + this.peso + "kg e mede " + this.altura + "cm de altura.";
    }
}
