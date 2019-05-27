package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char [][] firstMatrix = matrix(rows, columns) ;
        char [][] secondMatrix =  matrix(rows, columns);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns ; j++) {
                char first = firstMatrix[i][j];
                char second = secondMatrix[i][j];
                if(first == second){
                    System.out.print(first + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();

        }
    }

    private static char [][] matrix(int rows, int columns) {
        char [][] readMatrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            String [] input = scanner.nextLine().split(" ");

            for (int j = 0; j < columns; j++) {
                readMatrix[i][j] = input[j].charAt(0);
            }
        }
        return readMatrix;
    }
}
