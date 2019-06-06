package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class HeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        int playerLife = 18500;
        double heiganLife = 3000000;
        int cloudSecond = 0;

        Integer[][] floor = new Integer[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                floor[i][j] = 0;
            }
        }

        int currentRow = 7;
        int currentCol = 7;
        String killingSpell = "";

        while (playerLife > 0 && heiganLife > 0) {
            heiganLife -= damage;

            if (cloudSecond == 1) {
                playerLife -= 3500;
                if (playerLife <= 0) {
                    killingSpell = "Plague Cloud";
                    break;
                }
                cloudSecond = 0;
            }
            if(heiganLife <= 0){
                break;
            }

            String[] input = scanner.nextLine().split(" ");
            String spell = input[0];
            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);

            range(floor, rowHit, colHit, 1);

            if (floor[currentRow][currentCol] == 1) {
                if (currentRow - 1 >= 0 && floor[currentRow - 1][currentCol] != 1) {
                    currentRow = currentRow - 1;
                } else if (currentCol + 1 < 15 && floor[currentRow][currentCol + 1] != 1) {
                    currentCol = currentCol + 1;
                } else if (currentRow + 1 < 15 && floor[currentRow + 1][currentCol] != 1) {
                    currentRow = currentRow + 1;
                } else if (currentCol - 1 >= 0 && floor[currentRow][currentCol - 1] != 1) {
                    currentCol = currentCol - 1;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerLife -= 3500;
                            cloudSecond = 1;
                            if(playerLife <= 0){
                                killingSpell = "Plague Cloud";
                            }
                            break;
                        case "Eruption":
                            playerLife -= 6000;
                            if(playerLife <= 0){
                                killingSpell = "Eruption";
                            }
                            break;
                    }
                }
            }
            range(floor, rowHit, colHit, 0);
        }
        if(heiganLife <= 0){
            System.out.println("Heigan: Defeated!");
        } else{
            System.out.printf("Heigan: %.2f\n",heiganLife);
        }
        if(playerLife <= 0){
            System.out.println("Player: Killed by " + killingSpell);
        } else{
            System.out.println("Player: " + playerLife);
        }
        System.out.println("Final position: " + currentRow + ", " + currentCol);

    }

    private static void range(Integer[][] floor, int rowHit, int colHit, int num) {
        for (int row = rowHit - 1; row <= rowHit + 1; row++) {
            for (int col = colHit - 1; col <= colHit + 1; col++) {
                if (isInrange(row, col)) {
                    floor[row][col] = num;
                }
            }
        }
    }


    private static boolean isInrange(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }
}
