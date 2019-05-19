package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        while(stack.size() > 0){
            System.out.print(stack.pop() + " ");
        }
    }
}
