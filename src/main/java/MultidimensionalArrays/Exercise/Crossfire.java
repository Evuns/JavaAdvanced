package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixRange = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixRange[0];
        int columns = matrixRange[1];

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 1; j <= columns; j++) {
                int num = i * columns + j;
                current.add(num);
            }
            matrix.add(current);
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] bomb = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = bomb[0];
            int column = bomb[1];
            int range = bomb[2];

            for (int i = row - range; i <= row + range; i++) {
                if (isInrange(i, column, matrix)) {
                    matrix.get(i).set(column, 0);
                }
            }
            for (int i = column - range; i <= column + range ; i++) {
                if(isInrange(row,i,matrix)){
                    matrix.get(row).set(i, 0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
              matrix.set(i,matrix.get(i).stream().filter(el -> el  != 0).collect(Collectors.toCollection(ArrayList::new)));
              if(matrix.get(i).size() == 0){
                  matrix.remove(i);
                  i--;
              }
            }

            command = scanner.nextLine();
        }
        print(matrix);
    }

    private static boolean isInrange(int row, int column, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && column >= 0 && column < matrix.get(row).size();
    }


    private static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
