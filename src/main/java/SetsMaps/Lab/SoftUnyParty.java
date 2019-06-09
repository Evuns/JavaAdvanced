package SetsMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUnyParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipList = new TreeSet<>();
        Set<String> regularList = new TreeSet<>();
        String person = "";

        while (!"Party".equalsIgnoreCase(person = scanner.nextLine())) {
            if (Character.isDigit(person.charAt(0))) {
                vipList.add(person);
            } else {
                regularList.add(person);
            }
        }

        while (!"End".equalsIgnoreCase(person = scanner.nextLine())) {
            if (Character.isDigit(person.charAt(0))) {
                vipList.remove(person);
            } else {
                regularList.remove(person);
            }
        }
        System.out.println(vipList.size() + regularList.size());
        if (vipList.size() > 0)
            System.out.println(String.join(" ", vipList).replaceAll(" ","\n"));

        if (regularList.size() > 0)
            System.out.println(String.join(" ", regularList).replaceAll(" ","\n"));
    }
}
