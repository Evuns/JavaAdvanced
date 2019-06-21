package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while(num-- > 0){
            String[] data = scanner.nextLine().split("\\s+");
            String make = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);
            Car newCar = new Car();
            newCar.setMake(make);
            newCar.setModel(model);
            newCar.setHorsePower(horsePower);

            cars.add(newCar);
        }
           cars.forEach(c-> System.out.println(c.getInfo()));;
    }
}
