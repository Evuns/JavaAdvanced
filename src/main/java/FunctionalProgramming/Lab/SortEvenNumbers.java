package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        List<Integer> numbers = Arrays.stream(input).map(Integer::parseInt).filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        numbers.sort((a,b) -> a.compareTo(b));
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
