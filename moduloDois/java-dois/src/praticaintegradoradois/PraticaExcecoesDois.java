package praticaintegradoradois;

public class PraticaExcecoesDois {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int razao = b / a;
            System.out.println("Resultado do cálculo da razão: " + razao + ".");
        } catch (IllegalArgumentException e) {
            System.out.println("Não pode ser dividido por zero!!!");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa Finalizado.");
        }
    }
}
