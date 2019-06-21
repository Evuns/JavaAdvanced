package DefiningClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> data = new ArrayList<>();

        while(n-- > 0){
            String [] personInfo = scanner.nextLine().split("\\s+");

            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            data.add(person);
        }

        data.stream().filter(c -> c.getAge() > 30)
                .sorted((a,b)-> a.getName().compareTo(b.getName()))
                .forEach(p ->System.out.println(String.format("%s - %d", p.getName(), p.getAge())));
    }
}
