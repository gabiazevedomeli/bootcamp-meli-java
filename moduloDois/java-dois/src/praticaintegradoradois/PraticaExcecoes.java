package praticaintegradoradois;

public class PraticaExcecoes {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

         try {
             int razao = b / a;
             System.out.println("Resultado do cálculo da razão: " + razao);
         } catch (Exception e) {
             System.out.println("Ocorreu um erro");
             System.out.println(e.getMessage());
         } finally {
             System.out.println("Programa Finalizado");
         }
    }
}
