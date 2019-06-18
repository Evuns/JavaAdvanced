package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"party!".equalsIgnoreCase(command)) {
            String[] whatToDo = command.split("\\s+");

            String comparator = whatToDo[1];
            String compare = whatToDo[2];
            Predicate<String> predicates = predicate(comparator, compare);

            List<String> addNames = new ArrayList<>();
            switch (whatToDo[0]) {
                case "Remove":
                    names.removeIf(predicates);
                    break;
                case "Double":
                    names.forEach(name -> {
                        if (predicates.test(name)) {
                            addNames.add(name);
                        }
                    });
                    break;
            }
            names.addAll(addNames);
            command = scanner.nextLine();
        }

        Collections.sort(names);
        System.out.println(names.size() == 0 ?
                "Nobody is going to the party!" :
                String.join(", ", names) + " are going to the party!");
    }

    public static Predicate<String> predicate(String removeOrDouble, String comparator) {
        Predicate<String> stringPredicate;
        switch (removeOrDouble) {
            case "StartsWith":
                stringPredicate = str -> str.startsWith(comparator);
                break;
            case "EndsWith":
                stringPredicate = str -> str.endsWith(comparator);
                break;
            default:
                stringPredicate = str -> str.length() == Integer.parseInt(comparator);
        }
        return stringPredicate;
    }
}
