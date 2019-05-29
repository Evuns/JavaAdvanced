package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][rows];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int first = 0;
        int second = 0;
        int column = rows - 1;

        for (int i = 0; i < rows; i++) {
            first += matrix[i][i];
            second += matrix[i][column];
            column --;
        }
        System.out.println(Math.abs(first - second));
    }
}

