package DefiningClasses.Exercise.RawData;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedList<Car> fragile = new LinkedList<>();
        LinkedList<Car> flamable = new LinkedList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double firstTirePressure = Double.parseDouble(data[5]);
            int firstTireAge = Integer.parseInt(data[6]);
            double secondTirePressure = Double.parseDouble(data[7]);
            int secondTireAge = Integer.parseInt(data[8]);
            double thirdTirePressure = Double.parseDouble(data[9]);
            int thirdTireAge = Integer.parseInt(data[10]);
            double fourthTirePressure = Double.parseDouble(data[11]);
            int fourthTireAge = Integer.parseInt(data[12]);

            Tires tires = new Tires(firstTirePressure,firstTireAge,
            secondTirePressure, secondTireAge,
            thirdTirePressure, thirdTireAge,
            fourthTirePressure, fourthTireAge);

            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(speed,power);

            Car car = new Car(model,engine,cargo,tires);

            if(cargoType.equalsIgnoreCase("fragile")){
                fragile.add(car);
            } else{
                flamable.add(car);
            }
        }
        String print = scanner.nextLine();
        if("fragile".equalsIgnoreCase(print)){
            fragile.stream().forEach(car -> {
                if (car.getTires().isPrintable(car.getTires())){
                    System.out.println(car.getModel());
                }
            });
        } else{
            flamable.stream().forEach(car -> {
                if(car.getEngine().getPower() > 250){
                    System.out.println(car.getModel());
                }
            });
        }
    }
}
