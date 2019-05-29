package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = -1;
        int columnIndex = -1;

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < columns - 1; c++) {
                int currentSum = getMatrixSum(matrix, r, c);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    rowIndex = r;
                    columnIndex = c;
                }
            }

        }
        System.out.println("Sum = " + maxSum);

        for (int i = rowIndex - 1; i < rowIndex + 2 ; i++) {
            for (int j = columnIndex - 1; j < columnIndex + 2 ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getMatrixSum(int[][] matrix, int rows, int columns) {
        int sum = 0;

        sum += matrix[rows][columns];
        sum += matrix[rows][columns - 1];
        sum += matrix[rows][columns + 1];
        sum += matrix[rows - 1][columns];
        sum += matrix[rows - 1][columns - 1];
        sum += matrix[rows - 1][columns + 1];
        sum += matrix[rows + 1][columns];
        sum += matrix[rows + 1][columns - 1];
        sum += matrix[rows + 1][columns + 1];

        return sum;
    }
}
