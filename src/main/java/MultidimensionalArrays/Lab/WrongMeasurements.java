package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int columns = matrix[0].length;
        int[][] newMatrix = new int[rows][columns];

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = data[0];
        int column = data[1];

        int numberToFind = matrix[row][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int number = matrix[i][j];
                if (number == numberToFind) {
                    int first = 0;
                    int second = 0;
                    int third = 0;
                    int fourth = 0;

                    if (i != 0) {
                        first = matrix[i - 1][j];
                        if (first == numberToFind) {
                            first = 0;
                        }
                    }
                    if (i != rows - 1) {
                        second = matrix[i + 1][j];
                        if (second == numberToFind) {
                            second = 0;
                        }
                    }
                    if (j != columns - 1) {
                        third = matrix[i][j + 1];
                        if (third == numberToFind) {
                            third = 0;
                        }
                    }
                    if (j != 0) {
                        fourth = matrix[i][j - 1];
                        if (fourth == numberToFind) {
                            fourth = 0;
                        }
                    }

                    number = first + second + third + fourth;
                }

                newMatrix[i][j] = number;
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
