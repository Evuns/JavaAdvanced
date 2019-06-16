package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = x -> System.out.println("Sir " + x );

        Arrays.stream(scanner.nextLine().split("\\s")).forEach(print);
    }
}
