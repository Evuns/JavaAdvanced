package StackQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stack2 = new ArrayDeque<>();

        while (!"Home".equalsIgnoreCase(input = scanner.nextLine())) {
            if(!"back".equalsIgnoreCase(input) && !"forward".equalsIgnoreCase(input)){
                stack.push(input);
                System.out.println(stack.peek());
                stack2.clear();
            } else if ("back".equalsIgnoreCase(input)){
                if(stack.size() > 1 ){
                    stack2.push(stack.pop());
                    System.out.println(stack.peek());
                } else{
                    System.out.println("no previous URLs");
                }
            } else {
                if(stack2.size() > 0) {
                    stack.push(stack2.pop());
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no next URLs");
                }
            }
        }
    }
}
