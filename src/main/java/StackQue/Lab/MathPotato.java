package StackQue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int num = scanner.nextInt();

        ArrayDeque<String> que = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            que.offer(names[i]);
        }
        int counter = 1;

        while (que.size() > 1) {
            for (int i = 0; i < num - 1; i++) {
                String kid = que.poll();
                que.offer(kid);

            }

            if (isPrime(counter)) {
                System.out.println("Prime " + que.peek());
            } else {

                System.out.println("Removed " + que.poll());
            }
            counter ++;
        }
        System.out.println("Last is " + que.peek());
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

