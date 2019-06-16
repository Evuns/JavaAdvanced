package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        UnaryOperator<int[]> add = x -> Arrays.stream(x).map(num -> ++num).toArray();
        UnaryOperator<int[]> multiply = x -> Arrays.stream(x).map(num -> num * 2).toArray();
        UnaryOperator<int[]> subtract = x -> Arrays.stream(x).map(num -> --num).toArray();
        Consumer<int[]> print = x -> Arrays.stream(x).forEach(num -> System.out.print(num + " "));

        String command;
        while (!"end".equalsIgnoreCase(command = scanner.nextLine())) {

            switch (command) {
                case "add":
                    input = add.apply(input);
                    break;
                case "multiply":
                   input = multiply.apply(input);
                    break;
                case "subtract":
                    input = subtract.apply(input);
                    break;
                default:
                    print.accept(input);
                    System.out.println();
            }
        }

    }
}
