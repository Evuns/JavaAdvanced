package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;


public class Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    char match = stack.pop();

                    if (match == '(' && current != ')' || match == '[' && current != ']'
                            || match == '{' && current != '}') {
                        System.out.println("NO");
                        return;
                    }

                }
            }

        }
        System.out.println("YES");
    }
}



