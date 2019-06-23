package EXAM;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] space = new char[rows][];

        for (int r = 0; r < rows; r++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            space[r] = input.toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                if (space[r][c] == 83) {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }
        int starPower = 0;

        while (true) {
            int startRow = currentRow;
            int startCol = currentCol;

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    currentRow -= 1;
                    break;
                case "down":
                    currentRow += 1;
                    break;
                case "right":
                    currentCol += 1;
                    break;
                case "left":
                    currentCol -= 1;
                    break;
            }
            if(currentRow < 0 || currentCol < 0 || currentRow >= rows || currentCol >= rows ){
                space[startRow][startCol] = '-';
                break;
            }
            if (space[currentRow][currentCol] > 48 && space[currentRow][currentCol] < 58) {
                starPower += Integer.parseInt(String.valueOf(space[currentRow][currentCol]));
            } else if (space[currentRow][currentCol] == 79) {
                space[currentRow][currentCol] = '-';
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < rows; c++) {
                        if (space[r][c] == 79) {
                            currentRow = r;
                            currentCol = c;
                        }
                    }

                }
            }
            space[currentRow][currentCol] = 83;
            space[startRow][startCol] = '-';
            if(starPower >= 50){
                break;
            }
        }

        if(starPower < 50 ){
            System.out.println("Bad news, the spaceship went to the void.");
        } else{
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }

        System.out.println("Star power collected: " + starPower);

        for (int r = 0; r < rows; r++) {
            System.out.println(Arrays.toString(space[r]).replaceAll("[\\[\\],\\s]",""));
        }
    }
}
