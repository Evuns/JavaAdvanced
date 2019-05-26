package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstRows = data[0];
        int firstColumns = data[1];

        int[][] firstMatrix = getInts(scanner, firstRows, firstColumns);

        int[] data2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int secondRows = data2[0];
        int secondColumns = data2[1];

        if (firstRows != secondRows || firstColumns != secondColumns) {
            System.out.println("not equal");
            return;
        }

        int[][] secondMatrix = getInts(scanner, secondRows, secondColumns);

        for (int i = 0; i < firstRows ; i++) {
            for (int j = 0; j < firstColumns ; j++) {
                int firsNum = firstMatrix[i][j];
                int secondNum = secondMatrix[i][j];

                if(firsNum != secondNum){
                    System.out.println("not equal");
                    return;
                }

            }

        }
        System.out.println("equal");

    }

    private static int[][] getInts(Scanner scanner, int firstRows, int firstColumns) {
        int[][] firstMatrix = new int[firstRows][firstColumns];
        for (int rows = 0; rows < firstRows; rows++) {
            int[] row = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int columns = 0; columns < firstColumns; columns++) {
                firstMatrix[rows][columns] = row[columns];
            }
        }
        return firstMatrix;
    }
}
