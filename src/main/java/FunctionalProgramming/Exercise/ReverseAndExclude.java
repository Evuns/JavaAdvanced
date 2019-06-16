package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int num = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> filtered = number -> number % num != 0;
        Consumer<Integer> print = x -> System.out.print(x + " ");
        Collections.reverse(input);
        input.stream().filter(filtered).forEach(print);
    }
}
