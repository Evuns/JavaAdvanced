package prepExam;

import java.util.Arrays;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] garden = new char[rows][];

        for (int r = 0; r < rows; r++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            garden[r] = input.toCharArray();
        }

        String command;
        int carrots = 0;
        int potatoes = 0;
        int cucumber = 0;
        int harmed = 0;

        while (!"End of Harvest".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] info = command.split("\\s+");
            int row = Integer.parseInt(info[1]);
            int col = Integer.parseInt(info[2]);
            if (row < rows && garden[row].length > col) {
                switch (info[0]) {
                    case "Harvest":
                        if (garden[row][col] != 32) {
                            if (garden[row][col] == 'L') {
                                cucumber++;
                            } else if (garden[row][col] == 'P') {
                                potatoes++;
                            } else {
                                carrots++;
                            }
                            garden[row][col] = 32;
                        }
                        break;
                    case "Mole":
                        if (garden[row][col] != 32) {
                            harmed++;
                            garden[row][col] = 32;
                        }
                        switch (info[3]) {
                            case "up":
                                for (int r = row; r >= 0; r -= 2) {
                                    if (garden[r].length > col) {
                                        if (garden[r][col] != 32) {
                                            harmed++;
                                            garden[r][col] = 32;
                                        }
                                    }
                                }
                                break;
                            case "down":
                                for (int r = row; r <= rows; r += 2) {
                                    if (garden[r].length > col) {
                                        if (garden[r][col] != 32) {
                                            harmed++;
                                            garden[r][col] = 32;
                                        }
                                    }
                                }
                                break;
                            case "left":
                                for (int c = col; c >= 0; c -= 2) {
                                    if (garden[row].length > col) {
                                        if (garden[row][c] != 32) {
                                            harmed++;
                                            garden[row][c] = 32;
                                        }
                                    }
                                }
                                break;
                            case "right":
                                for (int c = col; c < garden[row].length; c += 2) {
                                    if (garden[row][c] != 32) {
                                        harmed++;
                                        garden[row][c] = 32;
                                    }
                                }
                                break;
                        }
                        break;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            System.out.println(Arrays.toString(garden[r]).replaceAll("[\\[\\],]",""));
        }
        System.out.printf("Carrots: %d\n" +
                        "Potatoes: %d\n" +
                        "Lettuce: %d\n" +
                        "Harmed vegetables: %d\n"
                , carrots, potatoes, cucumber, harmed);
    }
}
