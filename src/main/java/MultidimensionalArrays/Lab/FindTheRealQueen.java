package MultidimensionalArrays.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] input = new char[8][8];

        List<Integer> rowsWithQueen = new ArrayList<>();
        List<Integer> columnsWithQueen = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            input[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int column = 0; column < 8; column++) {
                char current = input[row][column];

                if (current == 'q') {
                    rowsWithQueen.add(row);
                    columnsWithQueen.add(column);
                }
            }
        }

        int[] isUniqueQueen = new int[rowsWithQueen.size()];
        for (int i = 0; i < rowsWithQueen.size(); i++) {
            int currentQueenRow = rowsWithQueen.get(i);
            int currentQueenColumn = columnsWithQueen.get(i);

            for (int j = i + 1; j < rowsWithQueen.size(); j++) {
                int nextQueenRow = rowsWithQueen.get(j);
                int nextQueenColumn = columnsWithQueen.get(j);
                int difference = nextQueenRow - currentQueenRow;
                if (currentQueenRow == nextQueenRow || currentQueenColumn == nextQueenColumn
                        || nextQueenColumn - currentQueenColumn == difference ||
                        currentQueenColumn - nextQueenColumn == difference) {
                    isUniqueQueen[j] = isUniqueQueen[i] = 1;
                }
            }
        }
        for (int i = 0; i < isUniqueQueen.length; i++) {
            if (isUniqueQueen[i] != 1){
                System.out.println(rowsWithQueen.get(i) + " " + columnsWithQueen.get(i));
            }

        }
    }
}
