package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int columns = input[1];

        String[][] matrix = new String[rows][columns];
        char chars = 'a';

        for (int i = 0; i < rows; i++) {
            char middle = chars;
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = "" + chars + middle + chars;
                middle++;
            }
            chars++;
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],]", ""));
        }
    }
}
