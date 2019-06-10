package SetsMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        Map<Character, Integer> occurrence = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            occurrence.putIfAbsent(input[i], 0);
            int times = occurrence.get(input[i]) + 1;
            occurrence.put(input[i], times);
        }

        occurrence.forEach((k, v) ->{
                    System.out.printf("%c: %d time/s\n",k,v);
                }
                );
    }
}
