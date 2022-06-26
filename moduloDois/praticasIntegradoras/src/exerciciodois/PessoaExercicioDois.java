package exerciciodois;

public class PessoaExercicioDois {
    String nome;
    int idade;
    String id;
    double peso;
    double altura;

    public PessoaExercicioDois() {
        // construtor padrão da classe que é chamado implicitamente quando instanciamos um objeto e não passamos nenhum parâmetro.
    }

    public PessoaExercicioDois(String nome, int idade, String id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        // construtor recebendo 3 parâmetros da classe PessoaExercicioDois
    }

    public PessoaExercicioDois(String nome, int idade, String id, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        // construtor recebendo todos os parâmetros da classe PessoaExercicioDois
    }
}
