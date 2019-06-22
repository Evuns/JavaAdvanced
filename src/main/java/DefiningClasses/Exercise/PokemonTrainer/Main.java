package DefiningClasses.Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String command;

        while (!"Tournament".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] data = command.split("\\s+");
            String trainerName = data[0];
            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(data[1], data[2], Integer.parseInt(data[3]));
            trainers.putIfAbsent(trainerName, trainer);
            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).setPokemons(pokemon);
            }
        }

        while (!"end".equalsIgnoreCase(command = scanner.nextLine())) {
            String c = command;
            trainers.forEach((s, trainer) -> {
                if (!trainer.containsElement(c)) {
                    trainer.getPokemons().forEach(Pokemon::setHealth);
                    trainer.removePokemon();
                }
            });
        }

        trainers.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().getNumberBadges(), a.getValue().getNumberBadges()))
                .forEach(entry ->
                        System.out.printf("%s %d %d%n", entry.getKey(), entry.getValue().getNumberBadges(),
                                entry.getValue().getPokemons().size()));
    }
}
