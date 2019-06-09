package SetsMaps.Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, ArrayList>> continents = new LinkedHashMap<>();

        int numberInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberInputs; i++) {
            String [] data = scanner.nextLine().split(" ");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList());
            continents.get(continent).get(country).add(city);

        }
        continents.forEach((k, v) -> {
            System.out.printf("%s:\n", k);
            v.entrySet().forEach(e -> System.out.printf("%s -> %s\n", e.getKey(),e.getValue().toString().replaceAll("\\[|\\]", "")));
        });

    }
}
