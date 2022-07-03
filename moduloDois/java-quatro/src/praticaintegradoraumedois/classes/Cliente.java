package praticaintegradoraumedois.classes;

public class Cliente {
    private String cpf, nome, sobrenome;

    public Cliente(String cpf, String nome, String sobrenome) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
