package DefiningClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String,Car> cars = new LinkedHashMap();

        while(n-- > 0){
            String [] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostPerKilo = Double.parseDouble(data[2]);

            Car car = new Car(model,fuelAmount,fuelCostPerKilo);

            cars.putIfAbsent(model,car);
        }

        String command;

        while(!"end".equalsIgnoreCase(command = scanner.nextLine())){
            String [] traveled = command.split("\\s+");
            String nameModel = traveled[1];
            int traveledKilometers = Integer.parseInt(traveled[2]);

            boolean travel = cars.get(nameModel).canTraveled(traveledKilometers);
            if(travel){
                double fuelAmountNeeded = traveledKilometers * cars.get(nameModel).getFuelCostPerKilo();
                cars.get(nameModel).setFuelAmount(fuelAmountNeeded);
                cars.get(nameModel).setKilometers(traveledKilometers);
            } else{
                System.out.println("Insufficient fuel for the drive");
            }
        }

        cars.entrySet().forEach(c ->
                System.out.println(String.format("%s %.2f %d", c.getValue().getModel(),
                        c.getValue().getFuelAmount(),
                        c.getValue().getKilometers())));
    }
}
