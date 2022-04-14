import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> totalPopulation = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            totalPopulation.putIfAbsent(country, new LinkedHashMap<>());
            totalPopulation.get(country).put(city, population);

            input = scanner.nextLine();
        }

        totalPopulation.entrySet().stream()
                .sorted((c1,c2) -> Long.compare(getTotalPopulation(c2.getValue()), getTotalPopulation(c1.getValue())))
                .forEach(c -> {
                    System.out.printf("%s (total population: %d)%n", c.getKey(), getTotalPopulation(c.getValue()));
                    c.getValue().entrySet().stream()
                            .sorted((p1, p2) -> Long.compare(p2.getValue(), p1.getValue()))
                            .forEach(e -> System.out.printf("=>%s: %d%n",e.getKey(),e.getValue()));
                });

    }

    private static long getTotalPopulation(Map<String, Long> v) {
        return v.values().stream().mapToLong(e -> e).sum();
    }
}
