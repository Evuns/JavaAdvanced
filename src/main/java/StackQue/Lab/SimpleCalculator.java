package StackQue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }
        while (stack.size() > 2) {
            int firstNum = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());
            int result = 0;

            if (operation.equals("+")) {
                result = firstNum + secondNum;
            } else {
                result = firstNum - secondNum;
            }

            stack.push(result + "");
        }
        System.out.println(stack.peek());
    }
}
