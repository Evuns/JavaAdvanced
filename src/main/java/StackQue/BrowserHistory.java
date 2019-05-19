package StackQue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!"Home".equalsIgnoreCase(input = scanner.nextLine())) {
            if(!"back".equalsIgnoreCase(input)){
                stack.push(input);
                System.out.println(stack.peek());
            } else{
                if(stack.size() > 1 ){
                    stack.pop();
                    System.out.println(stack.peek());
                } else{
                    System.out.println("no previous URLs");
                }
            }
        }
    }
}
