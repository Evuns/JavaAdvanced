package SetsMaps.Lab;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopList = new TreeMap<>();

        String data = scanner.nextLine();


        while (!"Revision".equals(data)) {
            String[] inputs = data.split(", ");
            String name = inputs[0];
            String product = inputs[1];
            double price = Double.parseDouble(inputs[2]);

            shopList.putIfAbsent(name, new LinkedHashMap<>());
            shopList.get(name).put(product, price);

            data = scanner.nextLine();
        }

        shopList.forEach((k, v) -> {
            System.out.printf("%s->\n", k);
            v.entrySet().forEach(e -> System.out.printf("Product: %s, Price: %.1f\n", e.getKey(),e.getValue()));
        });
    }
}
