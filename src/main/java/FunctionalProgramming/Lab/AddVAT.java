package FunctionalProgramming.Lab;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;


public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        UnaryOperator<Double> addTaxes = x -> 1.2 * x;

        System.out.println("Prices with VAT:");
        Arrays.stream(input).mapToDouble(Double::parseDouble)
                .map(addTaxes::apply).forEach(price -> System.out.printf("%.2f%n",price));
    }
}
