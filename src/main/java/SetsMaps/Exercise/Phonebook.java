package SetsMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> phoneBook = new HashMap<>();

        String command = scanner.nextLine();

        while(!"search".equalsIgnoreCase(command)){
            String [] data = command.split("-");
            String name = data[0];
            String number = data[1];

            phoneBook.put(name,number);
            command = scanner.nextLine();
        }

        while (!"stop".equalsIgnoreCase(command = scanner.nextLine())){
            if(phoneBook.containsKey(command)){
                System.out.printf("%s -> %s\n",command,phoneBook.get(command));
            } else{
                System.out.printf("Contact %s does not exist.\n",command);
            }
        }

    }
}
