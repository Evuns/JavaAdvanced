package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;


public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxNum = new ArrayDeque<>();

        int numberCommands = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numberCommands; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                int toPut = scanner.nextInt();
                stack.push(toPut);
                if (max <= toPut) {
                    max = toPut;
                    maxNum.push(max);
                }

            } else if (command == 2) {
                int poppedItem = stack.pop();
                if (poppedItem == max) {
                    maxNum.pop();
                    if (maxNum.size() > 0) {
                        max = maxNum.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(max);
            }
        }
    }
}



