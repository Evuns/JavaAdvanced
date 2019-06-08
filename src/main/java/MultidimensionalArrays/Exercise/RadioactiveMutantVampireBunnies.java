package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] lair = new String[rows][cols];

        int currentRow = 0;
        int currentCol = 0;
        int previousRow = currentRow;
        int previousCol = currentCol;

        for (int i = 0; i < rows; i++) {
            lair[i] = scanner.nextLine().split("");
            for (int j = 0; j < cols; j++) {
                if (lair[i][j].equalsIgnoreCase("P")) {
                    currentRow = i;
                    currentCol = j;
                    previousRow = currentRow;
                    previousCol = currentCol;
                }
            }
        }
        String[] movements = scanner.nextLine().split("");
        boolean isDead = false;

        for (int i = 0; i < movements.length; i++) {
            ArrayList<Integer> rowBunny = new ArrayList<>();
            ArrayList<Integer> colBunny = new ArrayList<>();
            if (lair[currentRow][currentCol].equalsIgnoreCase("P")) {
                switch (movements[i]) {
                    case "R":
                        currentCol += 1;
                        break;
                    case "L":
                        currentCol -= 1;
                        break;
                    case "U":
                        currentRow -= 1;
                        break;
                    default:
                        currentRow += 1;
                }

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        if (lair[r][c].equalsIgnoreCase("B")) {
                            rowBunny.add(r);
                            colBunny.add(c);
                        }
                    }
                }
                for (int j = 0; j < rowBunny.size(); j++) {
                    multiplyBunnies(lair, rowBunny.get(j), colBunny.get(j), rows, cols);
                }
                if (currentRow >= rows || currentRow < 0 || currentCol < 0 || currentCol >= cols) {
                    isFree(previousCol, lair[previousRow], "P");

                    print(lair, isDead, previousRow, previousCol);
                    break;
                } else if (lair[currentRow][currentCol].equalsIgnoreCase("B")) {
                    isDead = true;
                    isFree(previousCol, lair[previousRow], "P");
                    print(lair, isDead, currentRow, currentCol);
                    break;
                } else {
                    isFree(previousCol, lair[previousRow], "p");
                    lair[currentRow][currentCol] = "P";
                    previousRow = currentRow;
                    previousCol = currentCol;
                }
            }
        }
    }

    private static void isFree(int previousCol, String[] strings, String p) {
        if (strings[previousCol].equalsIgnoreCase(p))
            strings[previousCol] = ".";
    }

    private static void multiplyBunnies(String[][] lair, int rowBunny, int colBunny, int rows, int cols) {
        int row1 = rowBunny - 1;
        int row2 = rowBunny + 1;
        int col1 = colBunny - 1;
        int col2 = colBunny + 1;

        if (row1 >= 0) {
            lair[row1][colBunny] = "B";
        }
        if (row2 < lair.length) {
            lair[row2][colBunny] = "B";
        }
        if (col1 >= 0) {
            lair[rowBunny][col1] = "B";
        }
        if (col2 < lair[rowBunny].length) {
            lair[rowBunny][col2] = "B";
        }
    }

    private static boolean isInrange(int row, int rows, int col, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static void print(String[][] lair, boolean isDead, int currentRow, int currentCol) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }

        if (isDead) {
            System.out.printf("dead: %s %s\n", currentRow, currentCol);
        } else {
            System.out.printf("won: %s %s\n", currentRow, currentCol);
        }
    }

}
