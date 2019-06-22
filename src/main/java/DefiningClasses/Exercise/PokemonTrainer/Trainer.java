package DefiningClasses.Exercise.PokemonTrainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {

    private String name;
    private int numberBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberBadges = 0;
        this.pokemons = new LinkedList<>();
    }

    public int getNumberBadges() {
        return this.numberBadges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public boolean containsElement(String element) {
        if (this.pokemons.stream().anyMatch(e -> e.getElement().equals(element))) {
            this.numberBadges++;
            return true;
        }
        return false;
    }

    public void removePokemon() {
        this.getPokemons().removeIf(pokemon-> pokemon.getHealth() <= 0);
    }
}
