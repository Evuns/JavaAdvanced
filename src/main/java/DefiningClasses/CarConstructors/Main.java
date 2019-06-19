package DefiningClasses.CarConstructors;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> cars = new ArrayList<>();

        while(num-- > 0){
            String [] data = scanner.nextLine().split("\\s+");
            if(data.length == 1){
                Car car = new Car(data[0]);
                cars.add(car);
            } else {
                String make = data[0];
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                Car newCar = new Car(make, model, horsePower);
                cars.add(newCar);
            }
        }

        cars.forEach(c-> System.out.println(c.carInfo()));
    }
}
