package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Consumer<List<Integer>> minValue = x-> {
            int position = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) <= min) {
                    min = x.get(i);
                    position = i;
                }
            }
            System.out.println(position);
        };
        minValue.accept(numbers);
    }
}
