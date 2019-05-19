package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] parameters = scanner.nextLine().split("\\s+");

        int add = Integer.parseInt(parameters[0]);
        int remove = Integer.parseInt(parameters[1]);
        int num = Integer.parseInt(parameters[2]);

        if (add == remove) {
            System.out.println(0);
        } else {

            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < add; i++) {
                stack.push(Integer.parseInt(input[i]));
            }
            for (int i = 0; i < remove; i++) {
                stack.pop();
            }

            if (stack.contains(num)) {
                System.out.println("true");
            } else {
                int min = stack.pop();
                while (stack.size() > 0) {
                    if (min > stack.peek()) {
                        min = stack.pop();
                    } else {
                        stack.pop();
                    }
                }
                System.out.println(min);
            }
        }
    }
}
