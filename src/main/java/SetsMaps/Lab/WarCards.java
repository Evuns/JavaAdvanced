package SetsMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class WarCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> player1 = new LinkedHashSet<>(Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList()));
        Set<Integer> player2 = new LinkedHashSet<>(Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList()));

        for (int i = 0; i < 50 ; i++) {
            if(player1.isEmpty() || player2.isEmpty())
                break;

            int firstPlayerCard = player1.iterator().next();
            player1.remove(firstPlayerCard);
            int secondPlayerCard = player2.iterator().next();
            player2.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard){
                player1.add(firstPlayerCard);
                player1.add(secondPlayerCard);
            } else if(secondPlayerCard > firstPlayerCard){
                player2.add(firstPlayerCard);
                player2.add(secondPlayerCard);
            } else{
                player1.add(firstPlayerCard);
                player2.add(secondPlayerCard);
            }
        }
        if(player1.size() > player2.size()){
            System.out.println("First player win!");
        } else if(player2.size() > player1.size()){
            System.out.println("Second player win!");
        } else{
            System.out.println("Draw!");
        }
    }
}