import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map <String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        continents.forEach((continent, countries) ->{
            System.out.println(continent +":");
            countries.forEach((country, city) -> System.out.printf("  %s -> %s%n",country, String.join(", ",city)));
        } );
    }
}
