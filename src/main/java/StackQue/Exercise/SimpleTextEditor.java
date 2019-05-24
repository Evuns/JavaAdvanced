package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> textStack = new ArrayDeque<>();
        ArrayDeque<String> commandsRecordStack = new ArrayDeque<>();


        String argument = "";
        while (n-- > 0) {
            String[] input = scanner.nextLine().split(" ");

            String command = input[0];

            if (input.length > 1) {
                argument = input[1];
            }

            switch (command) {
                case "1":
                    String before = textStack.toString();
                    commandsRecordStack.push(before);
                    String[] chars = argument.split("");

                    for (int i = 0; i < chars.length; i++) {
                        String current = chars[i];
                        textStack.push(current);
                    }
                    break;
                case "2":
                    before = textStack.toString();
                    commandsRecordStack.push(before);
                    int elements = Integer.parseInt(argument);
                    if (textStack.size() >= elements) {
                        while (elements-- > 0) {
                            textStack.pop();
                        }
                    }
                    break;
                case "3":
                    ArrayDeque<String> textToPrintQue = textStack.clone();
                    elements = Integer.parseInt(argument);
                    while (elements-- >= 0) {
                        if (elements == 0) {
                            System.out.println(textToPrintQue.pollLast());
                        }
                        textToPrintQue.pollLast();
                    }
                    break;
                default:
                    textStack.clear();
                    if (commandsRecordStack.size() > 0) {
                        if (commandsRecordStack.peek().equals("[]")) {
                            commandsRecordStack.pop();
                            textStack.clear();
                        } else {
                            String[] current = commandsRecordStack.pop().replaceAll("\\[|,|\\]|\\s+", "").split("");
                            for (int i = 0; i < current.length; i++) {
                                textStack.offer(current[i]);
                            }
                        }
                    } else {
                        textStack.clear();
                    }

            }
        }
    }
}

