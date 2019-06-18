package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;

public class PartyReservationFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] invited = scanner.nextLine().split("\\s+");

        String command = scanner.nextLine();
        HashMap<String,Predicate<String>> filters = new HashMap<>();

        while (!"Print".equalsIgnoreCase(command)) {
            String[] data = command.split(";");

            String comparator = data[1];
            String compare = data[2];
            String filterName = comparator + compare;

            switch (data[0]) {
                case "Add filter":
                    Predicate<String> predicate;
                    if(comparator.contains("Starts")){
                        predicate = text -> text.startsWith(compare);
                    } else if(comparator.contains("Ends")){
                        predicate = text -> text.endsWith(compare);
                    } else if(comparator.contains("Length")){
                        predicate = text -> text.length() == Integer.parseInt(compare);
                    } else{
                        predicate = text -> text.contains(compare);
                    }
                    filters.putIfAbsent(filterName,predicate);
                    break;
                case "Remove filter":
                    filters.remove(filterName);
            }
            command = scanner.nextLine();
        }
        Arrays.stream(invited).forEach(name->{
            boolean[] toRemove = new boolean[1];
            filters.forEach((k,v) ->{
                if(v.test(name)){
                    toRemove[0] = true;
                }
            });
            if(!toRemove[0]){
                System.out.print(name + " ");
            }
        });
    }
}
