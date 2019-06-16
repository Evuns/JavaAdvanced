package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Function<int[],Integer> func = x -> {
            int min = Arrays.stream(x).min().getAsInt();
         return min;
        };

        System.out.println(func.apply(input));
    }
}
