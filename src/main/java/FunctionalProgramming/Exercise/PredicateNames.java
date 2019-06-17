package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> shorter = x -> x.length() <= length;
        Consumer<String> print = System.out::println;

        Arrays.stream(names).filter(shorter::test).forEach(print);
    }
}
