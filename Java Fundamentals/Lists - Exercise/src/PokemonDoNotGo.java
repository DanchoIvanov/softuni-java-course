import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemon = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!pokemon.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0){
                index = 0;
                pokemon.add(1, pokemon.get(pokemon.size()-1));
            } else if (index > pokemon.size()-1) {
                index = pokemon.size()-1;
                pokemon.add(pokemon.get(0));
            }

            int currentValue = pokemon.get(index);
            sum+=currentValue;
            pokemon.remove(index);
            for (int i = 0; i < pokemon.size(); i++) {
                if (pokemon.get(i) > currentValue) {
                    pokemon.set(i, pokemon.get(i) - currentValue);
                } else {
                    pokemon.set(i, pokemon.get(i) + currentValue);
                }
            }
        }
        System.out.println(sum);
    }
}
