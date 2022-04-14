package pokemon_trainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        this.numberOfBadges = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean containsPokemonOfElement(String element){
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
            return false;
    }

    public void takeDamage() {
        for (Pokemon pokemon : this.pokemons) {
            pokemon.setHealth(pokemon.getHealth() - 10);
        }
        pokemons.removeIf(p -> p.getHealth() <=0);
    }
}
