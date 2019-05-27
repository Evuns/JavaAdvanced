package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] data = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = data[0];
        int columns = data[1];
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            int [] elements = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < columns ; j++) {
                int element = elements[j];
                sum += element;
            }

        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
