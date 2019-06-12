package SetsMaps.Exercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Map<String, List<String>>> users = new TreeMap<>();

        while (!"end".equalsIgnoreCase(command)) {
            String[] data = command.split("\\s");
            String ip = data[0].substring(3);
            String message = data[1];
            String user = data[2].substring(5);

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(ip, new ArrayList<>());
            users.get(user).get(ip).add(message);

            //IP=192.23.30.40 message='Hello&derps.' user=destroyer


            command = scanner.nextLine();
        }

        users.forEach((k, v) -> {
            System.out.printf("%s:\n", k);
            int counter = 0;
            v.forEach((key,value)->{

            });
            for (Map.Entry<String,List<String>> entry : v.entrySet()) {
                System.out.printf("%s%s => %d", counter ++ == 0 ? "" : ", ",entry.getKey(),entry.getValue().size());
            }
            System.out.println(".");
        });
    }
}
