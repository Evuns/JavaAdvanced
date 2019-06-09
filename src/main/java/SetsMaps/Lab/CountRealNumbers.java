package SetsMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double,Integer> numbersCount = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < input.length; i++) {
            double key = input[i];
            numbersCount.putIfAbsent(key,0);
            numbersCount.put(key, numbersCount.get(key) + 1);
        }

        for (Map.Entry<Double,Integer> entry:numbersCount.entrySet()){
            System.out.println(String.format("%.1f -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
