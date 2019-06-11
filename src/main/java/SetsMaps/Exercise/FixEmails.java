package SetsMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> namesEmails = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"stop".equalsIgnoreCase(command)) {
            String email = scanner.nextLine();
            String domain = email.substring(email.length() - 3);

            if (!".uk".equalsIgnoreCase(domain) &&
                    !".us".equalsIgnoreCase(domain) &&
                    !"com".equalsIgnoreCase(domain)) {
                namesEmails.put(command, email);
            }

            command = scanner.nextLine();
        }

        namesEmails.forEach((k, v) -> {
            System.out.printf("%s -> %s\n", k, v);
        });
    }
}
