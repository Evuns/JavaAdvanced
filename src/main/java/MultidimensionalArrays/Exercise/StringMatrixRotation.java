package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int degree = Integer.parseInt(command.substring(7, command.length() - 1));

        String matrixLines = scanner.nextLine();

        List<String> matrixArray = new ArrayList<>();
        int longest = 0;

        while (!matrixLines.equalsIgnoreCase("end")) {
            matrixArray.add(matrixLines);
            if (matrixLines.length() > longest) {
                longest = matrixLines.length();
            }
            matrixLines = scanner.nextLine();
        }
        Character[][] matrix = new Character[matrixArray.size()][longest];

        for (int i = 0; i < matrixArray.size(); i++) {
            for (int j = 0; j < longest; j++) {
                if (matrixArray.get(i).length() <= j) {
                    matrix[i][j] = '\0';
                } else {
                    matrix[i][j] = matrixArray.get(i).charAt(j);
                }
            }

        }

        while (degree >= 360) {
            degree -= 360;
        }

        switch (degree) {
            case 0:
                printing0(matrix);
                break;
            case 90:
                printing90(matrix, longest);
                break;
            case 180:
                printing180(matrix);
                break;
            default:
                printing270(matrix,longest);

        }
    }

    private static void printing0(Character matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '\0') {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void printing90(Character matrix[][], int longest) {
        for (int i = 0; i < longest; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (matrix[j][i] == '\0') {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[j][i]);
                }
            }
            System.out.println();
        }
    }

    private static void printing180(Character matrix[][]) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0;  j--) {
                if (matrix[i][j] == '\0') {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void printing270(Character matrix[][], int longest) {
        for (int i = longest - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length ; j++) {
                if (matrix[j][i] == '\0') {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[j][i]);
                }
            }
            System.out.println();
        }
    }
}
