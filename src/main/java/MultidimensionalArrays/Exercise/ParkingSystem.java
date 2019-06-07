package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String command = scanner.nextLine();
        byte[][] parkingLot = new byte[rows][cols];
        int[] fullRows = new int[rows];


        while (!"stop".equalsIgnoreCase(command)) {

            int[] data = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int enter = data[0];
            int row = data[1];
            int col = data[2];

            if (fullRows[row] < cols - 1) {
                fullRows[row]++;
                if (parkingLot[row][col] == 1) {
                    col = findFreeSpace(parkingLot[row], col);
                }
                parkingLot[row][col] = 1;

                System.out.println(Math.abs(enter - row) + col + 1);

            } else {
                System.out.println("Row " + row + " full");
            }


            command = scanner.nextLine();
        }
    }

    private static int findFreeSpace(byte[] parkingLot, int col) {
        int toBeginning = 0;
        int toEnd = 0;
        for (int i = 1; i < parkingLot.length ; i++) {
            toBeginning = col - i;
            toEnd = col + i;

            if(toBeginning > 0 && parkingLot[toBeginning] == 0){
                return  toBeginning;
            } else if(toEnd < parkingLot.length && parkingLot[toEnd] == 0){
                return toEnd;
            }
        }
        return -1;
    }

}