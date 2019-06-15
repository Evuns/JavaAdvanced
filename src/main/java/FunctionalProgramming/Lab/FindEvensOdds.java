package FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        boolean isEven = scanner.nextLine().equalsIgnoreCase("odd");
        Predicate<Integer> even = x -> x % 2 == 0;
        Predicate<Integer> odd = x -> x % 2 != 0;
        Predicate<Integer> evenOdd = even;
        if (isEven) evenOdd = odd;

        Consumer<Integer> print = p -> System.out.print(p + " ");

       IntStream.rangeClosed(Integer.parseInt(input[0]), Integer.parseInt(input[1]))
                .boxed().filter(evenOdd).forEach(print);

    }
}
