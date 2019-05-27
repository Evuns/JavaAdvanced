package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsColumns = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[rowsColumns][rowsColumns];

        for (int i = 0; i < rowsColumns ; i++) {
            String [] row = scanner.nextLine().split(" ");
           matrix[i] = row;
        }

            for (int j = 0; j < rowsColumns; j++) {
                System.out.print(matrix[j][j] + " ");
            }
            System.out.println();

            int column = 0;

        for (int i = rowsColumns - 1; i >= 0 ; i--) {
            System.out.print(matrix[i][column] + " ");
            column ++;
        }
    }
}
