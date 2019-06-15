package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        System.out.println("Count = " + input.length);

        Function<String, Integer> num = x -> Integer.parseInt(x);

        System.out.println("Sum = " + Arrays.stream(input).map(num).reduce(0, (sum, element) -> sum + element));
    }
}
