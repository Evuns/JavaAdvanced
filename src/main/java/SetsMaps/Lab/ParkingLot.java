package SetsMaps.Lab;

import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new HashSet<>();

        String input = scanner.nextLine();

        while (!"END".equalsIgnoreCase(input)) {
            String[] data = input.split(", ");
            String direction = data[0];
            String car = data[1];

            switch (direction) {
                case "IN":
                    parkingLot.add(car);
                    break;
                case "OUT":
                    parkingLot.remove(car);
            }
            input = scanner.nextLine();
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}
