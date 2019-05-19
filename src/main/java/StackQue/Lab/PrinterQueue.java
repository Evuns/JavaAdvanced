package StackQue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> que = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!"print".equalsIgnoreCase(input)) {
            if (!"cancel".equalsIgnoreCase(input)) {
                que.offer(input);
            } else {
                if (que.size() >= 1) {
                    System.out.println("Canceled " + que.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            input = scanner.nextLine();
        }
        while (que.size() > 0) {

            System.out.println(que.poll());
        }
    }
}
