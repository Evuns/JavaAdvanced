package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] data = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = data[0];
        int columns = data[1];

        int [][] originalMatrix = new int[rows][columns];
        int [][] sumMatrix = new int[rows][columns - 1];

        for (int i = 0; i < rows ; i++) {
            int [] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < columns - 1; j++) {
                int first = input [j];
                int second = input [j + 1];
                originalMatrix [i][j] = first;
                sumMatrix[i][j] = first + second;
            }
            originalMatrix[i][columns - 1] = input[columns - 1];
        }

        int theBiggest = Integer.MIN_VALUE;
        int [][] toPrint = new int[2][2];

        for (int i = 0; i < rows - 1 ; i++) {
            for (int j = 0; j < columns - 1 ; j++) {
                int firstSum = sumMatrix[i][j];
                int secondSum = sumMatrix[i + 1][j];

                if(firstSum + secondSum > theBiggest){
                    theBiggest = firstSum + secondSum;
                    toPrint[0][0] = originalMatrix[i][j] ;
                    toPrint[0][1] = originalMatrix[i][j + 1];
                    toPrint[1][0] = originalMatrix[i + 1][j];
                    toPrint[1][1] = originalMatrix [i + 1][j + 1];
                }
            }

        }
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(toPrint[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(theBiggest);
    }
}
