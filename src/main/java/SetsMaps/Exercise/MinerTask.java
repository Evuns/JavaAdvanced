package SetsMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> resources = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while(!"stop".equalsIgnoreCase(command)){
            resources.putIfAbsent(command,0);
            int value = Integer.parseInt(scanner.nextLine());
            int sum = resources.get(command) + value;
            resources.put(command,sum);

            command = scanner.nextLine();
        }

        resources.forEach((k,v)->{
            System.out.printf("%s -> %d\n",k,v);
        });
    }
}
