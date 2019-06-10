package SetsMaps.Exercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String[] chemicals = scanner.nextLine().split(" ");
            for (int j = 0; j < chemicals.length; j++) {
                elements.add(chemicals[j]);
            }
        }
        System.out.println(String.join(" ", elements));
    }
}
