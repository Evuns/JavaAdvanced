package StackQue.Lab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int num = scanner.nextInt();

        ArrayDeque<String> que = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            que.offer(names[i]);
        }

        while (que.size() > 1){
            for (int i = 0; i < num - 1 ; i++) {
                String kid = que.poll();
                que.offer(kid);
            }
            System.out.println("Removed " + que.poll());
        }
        System.out.println("Last is " + que.peek());
    }
}
