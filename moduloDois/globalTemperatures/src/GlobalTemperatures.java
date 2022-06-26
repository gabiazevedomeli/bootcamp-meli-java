public class GlobalTemperatures {
    public static void main(String[] args) {

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperatures[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int maxTemperature = 0;
        int minTemperature = 0;
        int maxCityIndex = 0;
        int minCityIndex = 0;

        for (int line = 0; line < temperatures.length; line++) {
            for (int column = 0; column < temperatures[line].length; column++) {
                if (temperatures[line][column] > maxTemperature) {
                    maxTemperature = temperatures[line][column];
                    maxCityIndex = line;
                }
                ;

                if (temperatures[line][column] < minTemperature) {
                    minTemperature = temperatures[line][column];
                    minCityIndex = line;
                }
            }
        }
        System.out.println("A temperatura mais baixa foi em: " + cities[minCityIndex] + ", com " + minTemperature + " graus.");
        System.out.println("A temperatura mais baixa foi em: " + cities[maxCityIndex] + ", com " + maxTemperature + " graus.");
    }
}
