package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lastNum = Integer.parseInt(scanner.nextLine());
        int [] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> predicate = x -> {
                for (int number:sequence) {
                    if(x % number != 0){
                        return false;
                    }
                }
                return true;
            };

        Consumer<Integer> print = x -> System.out.print(x + " ");
        IntStream.rangeClosed(1,lastNum).boxed().filter(predicate).forEach(print);
    }
}
