package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> que = new ArrayDeque<>();

        int elements = scanner.nextInt();
        int toRemove = scanner.nextInt();
        int isPresent = scanner.nextInt();
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < elements; i++) {
            que.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < toRemove; i++) {
            que.poll();
        }
        if (que.size() == 0) {
            System.out.println(0);
        } else {
            if (que.contains(isPresent)) {
                System.out.println("true");
            } else {
                int min = Integer.MAX_VALUE;
                while (que.size() > 0) {
                    int current = que.poll();
                    if (current < min) {
                        min = current;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
