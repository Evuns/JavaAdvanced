package StackQue.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] names = new String[input.length];
        int[] operationTime = new int[input.length];
        int[] workTime = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            names[i] = data[0];
            operationTime[i] = Integer.parseInt(data[1]);
        }

        String[] startingTime = scanner.nextLine().split(":");
        int hour = Integer.parseInt(startingTime[0]);
        int minutes = Integer.parseInt(startingTime[1]);
        int seconds = Integer.parseInt(startingTime[2]);

        int beginsSeconds = hour * 3600 + minutes * 60 + seconds;

        String product = "";

        ArrayDeque<String> productsQue = new ArrayDeque<>();

        while (!"End".equalsIgnoreCase(product = scanner.nextLine())) {
            productsQue.offer(product);
        }

        ArrayDeque<String> workingRobots = new ArrayDeque<>();
        while (!productsQue.isEmpty()) {
            beginsSeconds++;

            String workingProduct = productsQue.poll();
            boolean isAssigned = false;

            for (int i = 0; i < names.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = operationTime[i];
                    isAssigned = true;
                    printRobotData(names[i], workingProduct, beginsSeconds);

                }

                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isAssigned) {
                productsQue.offer(workingProduct);
            }
        }

    }

    private static void printRobotData(String name, String workingProduct, int beginsSeconds) {
        int sec = beginsSeconds % 60;
        int min = (beginsSeconds / 60) % 60;
        int hour = (beginsSeconds / 3600) % 24;
        System.out.println(name + " - " + workingProduct + String.format(" [%02d:%02d:%02d]",hour,min,sec));
    }
}

