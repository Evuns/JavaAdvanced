package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");

        Predicate<String> isUpper = x -> x.charAt(0) >  64 && x.charAt(0) < 91;

        List<String> upperWords = Arrays.stream(input).
                filter(isUpper)
                .collect(Collectors.toList());

        System.out.println(upperWords.size());
        upperWords.forEach(System.out::println);

    }
}
