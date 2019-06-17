package FunctionalProgramming.Exercise;

import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Comparator<Integer> compare = (f,s) ->{
           int result;
           if(f % 2 == 0 && s % 2 != 0){
               result = -1;
           } else if(s % 2 == 0 && f % 2 != 0){
               result = 1;
           } else{
               result = f - s;
           }
           return result;
       };

       Arrays.stream(scanner.nextLine().split("\\s+"))
       .map(Integer::parseInt).sorted(compare)
       .forEach(x -> System.out.print(x + " "));
    }
}
