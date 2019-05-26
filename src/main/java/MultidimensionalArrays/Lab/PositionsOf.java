package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = data[0];
        int columns = data[1];

        int [][] matrix = new int [rows][columns];

        for (int row = 0; row < rows ; row++) {
            int[] columnContain = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int column = 0; column < columns ; column++) {
                matrix[row][column] = columnContain[column];
            }
        }
        boolean found = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns ; j++) {
                int matrixNumber = matrix[i][j];
                if(number == matrixNumber){
                    System.out.println(i + " " + j);
                    found = true;
                }

            }
        }
        if(!found){
            System.out.println("not found");
        }
    }
}
