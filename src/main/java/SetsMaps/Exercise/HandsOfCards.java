package SetsMaps.Exercise;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cards = scanner.nextLine();
        Map<String, Integer> playersScores = new LinkedHashMap<>();
        Map<String, ArrayList<String>> playersCards = new HashMap<>();

        while (!"Joker".equalsIgnoreCase(cards)) {
            String[] data = cards.split(": ");
            String name = data[0];
            String[] playerCards = data[1].split(", ");

            playersCards.putIfAbsent(name,new ArrayList<>());
            playersScores.putIfAbsent(name,0);

            for (int i = 0; i < playerCards.length; i++) {
                if (!playersCards.get(name).contains(playerCards[i])) {
                    playersCards.get(name).add(playerCards[i]);

                    int card = 0;
                    if (playerCards[i].length() > 2) {
                        card = 10;
                    } else {
                        switch (playerCards[i].charAt(0)) {
                            case 'J':
                                card = 11;
                                break;
                            case 'Q':
                                card = 12;
                                break;
                            case 'K':
                                card = 13;
                                break;
                            case 'A':
                                card = 14;
                                break;
                            default:
                                card = Integer.parseInt(playerCards[i].substring(0, 1));
                        }
                    }

                    int type = 0;
                    switch (playerCards[i].charAt(playerCards[i].length() - 1)) {
                        case 'S':
                            type = 4;
                            break;
                        case 'H':
                            type = 3;
                            break;
                        case 'D':
                            type = 2;
                            break;
                        case 'C':
                            type = 1;
                            break;
                    }
                    int sum = card * type + playersScores.get(name);
                    playersScores.put(name,sum);
                }
            }

            cards = scanner.nextLine();
        }
        playersScores.forEach((k,v)->{
            System.out.printf("%s: %d\n",k,v);
        });
    }
}
