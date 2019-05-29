package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("End")) {
            String[] isCorrect = command.split(" ");
            if (isCorrect.length != 5 || !isCorrect[0].equalsIgnoreCase("swap")) {
                System.out.println("Invalid input!");
            } else {
                int firstCoordinate = Integer.parseInt(isCorrect[1]);
                int secondCoordinate = Integer.parseInt(isCorrect[2]);
                int thirdCoordinate = Integer.parseInt(isCorrect[3]);
                int fourthCoordinate = Integer.parseInt(isCorrect[4]);
                if (firstCoordinate >= rows || secondCoordinate >= columns || thirdCoordinate >= rows || fourthCoordinate >= columns
                        || firstCoordinate < 0 || secondCoordinate < 0 || thirdCoordinate < 0 || fourthCoordinate < 0) {
                    System.out.println("Invalid input!");
                } else {
                    String toSwap = matrix[firstCoordinate][secondCoordinate];
                    String swapWith = matrix[thirdCoordinate][fourthCoordinate];

                    matrix[firstCoordinate][secondCoordinate] = swapWith;
                    matrix[thirdCoordinate][fourthCoordinate] = toSwap;

                    for (int i = 0; i < rows; i++) {
                        System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],]", ""));
                    }
                }
            }

            command = scanner.nextLine();
        }
    }
}
