package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> person = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            person.put(data[0], Integer.parseInt(data[1]));
        }
        boolean comparator = scanner.nextLine().equalsIgnoreCase("older");
        int compareTo = Integer.parseInt(scanner.nextLine());
        String toPrint = scanner.nextLine();

        BiPredicate<Integer, Integer> older = (x, y) -> x >= y;
        BiPredicate<Integer, Integer> younger = (x, y) -> x <= y;

        Consumer<Map.Entry<String, Integer>> print = p -> {
            switch (toPrint) {
                case "name":
                    System.out.printf("%s%n", p.getKey());
                    break;
                case "age":
                    System.out.printf("%d%n", p.getValue());
                    break;
                default:
                    System.out.printf("%s - %d%n", p.getKey(), p.getValue());
            }
        };

        person.entrySet().stream()
                .filter(p -> comparator ? older.test(p.getValue(), compareTo) :
                        younger.test(p.getValue(), compareTo)).forEach(print);
    }
}
