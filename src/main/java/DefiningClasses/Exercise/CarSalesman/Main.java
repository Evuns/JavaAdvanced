package DefiningClasses.Exercise.CarSalesman;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Engine> engineList = new LinkedHashMap<>();
        LinkedList<Car> cars = new LinkedList<>();

        while (n-- > 0) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            Engine engine = new Engine(model, engineInfo[1]);
            if (engineInfo.length >= 3) {
                if (Character.isDigit(engineInfo[2].charAt(0))) {
                    engine.setDisplacement(engineInfo[2]);
                } else {
                    engine.setEfficiency(engineInfo[2]);
                }
            }
            if (engineInfo.length == 4) {
                engine.setEfficiency(engineInfo[3]);
            }

            engineList.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String engineModel = carInfo[1];
            Car car = new Car(carInfo[0], engineList.get(engineModel));
            if (carInfo.length >= 3) {
                if (Character.isDigit(carInfo[2].charAt(0))) {
                    car.setWeight(carInfo[2]);
                } else {
                    car.setColor(carInfo[2]);

                }
            }
            if (carInfo.length == 4) {
                car.setColor(carInfo[3]);
            }
            cars.add(car);
        }

        cars.forEach(car -> {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().getModel() + ":");
            System.out.println("Power: " + car.getEngine().getPower());
            System.out.println("Displacement: " + car.getEngine().getDisplacement());
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        });
    }
}
