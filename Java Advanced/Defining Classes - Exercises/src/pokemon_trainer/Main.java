package pokemon_trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")){
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainers.get(trainerName).getPokemons().add(pokemon);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")){
            String element = input;
            for (Trainer trainer : trainers.values()){
                if (trainer.containsPokemonOfElement(element)){
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                } else {
                    trainer.takeDamage();
                }
            }
            input = scanner.nextLine();
        }
        trainers.values().stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(t -> System.out.printf("%s %d %d%n", t.getName(), t.getNumberOfBadges(), t.getPokemons().size()));
    }
}
