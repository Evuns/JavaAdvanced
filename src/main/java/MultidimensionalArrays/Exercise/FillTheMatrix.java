package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(data[0]);
        String type = data[1];

        int[][] matrix = new int[rows][rows];


        int value = 1;
        if (type.equalsIgnoreCase("A")) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = value++;
                }
            }
        } else {
            for (int i = 0; i < rows; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < rows; j++) {
                        matrix[j][i] = value++;
                    }
                } else {
                    for (int j = rows - 1; j >= 0; j--) {
                        matrix[j][i] = value++;

                    }
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
