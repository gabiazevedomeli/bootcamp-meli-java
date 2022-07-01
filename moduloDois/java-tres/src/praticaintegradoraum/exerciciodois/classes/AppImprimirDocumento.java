package praticaintegradoraum.exerciciodois.classes;

import praticaintegradoraum.exerciciodois.interfaces.Imprimir;

import java.util.ArrayList;
import java.util.List;

public class AppImprimirDocumento {
    public static void main(String[] args) {
        Pessoa pessoaUm = new Pessoa("Gabriela Azevedo", 33, "123.456.789-00");

        Habilidade habilidadeUm = new Habilidade("Gosta de programar e aprender novas tecnologias");
        Habilidade habilidadeDois = new Habilidade("É organizada e comprometida.");
        List<Habilidade> habilidadesList = new ArrayList<>();
        habilidadesList.add(habilidadeUm);
        habilidadesList.add(habilidadeDois);

        Curriculo curriculoPessoaUm = new Curriculo("001", pessoaUm, habilidadesList);
        Imprimir.imprimeDocumento(curriculoPessoaUm);

        LivrosEmPDF livro = new LivrosEmPDF("001", 968, "Paul Deitel | Harvey Deitel", "Como Programar em Java", "tecnologia/técnico");
        Imprimir.imprimeDocumento(livro);

        Relatorios relatorio = new Relatorios("001", "Como Programar Orientado à Objetos...", 300, "Márcia Freitas", "Leandro Martins");
        Imprimir.imprimeDocumento(relatorio);
    }
}
