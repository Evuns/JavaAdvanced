package SetsMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        while(num -- > 0){
            String username = scanner.nextLine();
            usernames.add(username);
        }

        for (String name: usernames) {
            System.out.println(name);
        }
    }
}
