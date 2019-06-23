package prepExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
        ArrayDeque<String> vegetableQue = new ArrayDeque<>();

        String[] vegetables = scanner.nextLine().split("\\s+");
        for (String vegetable : vegetables) {
            vegetableQue.offer(vegetable);
        }
        int[] calories = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int calorie : calories) {
            caloriesStack.push(calorie);
        }
        int tomato = 80;
        int carrot = 136;
        int lettuce = 109;
        int potato = 215;

        ArrayDeque<Integer> madeSaladsQue = new ArrayDeque<>();

        boolean stop = false;
        for (int i = 0; i < calories.length; i++) {
            int salad = caloriesStack.pop();
            int saladCalories = salad;

            while (saladCalories > 0 && !vegetableQue.isEmpty()) {
                    String vegetable = vegetableQue.poll();
                    switch (vegetable) {
                        case "tomato":
                            saladCalories -= tomato;
                            break;
                        case "carrot":
                            saladCalories -= carrot;
                            break;
                        case "lettuce":
                            saladCalories -= lettuce;
                            break;
                        case "potato":
                            saladCalories -= potato;
                            break;
                    }
            }
            madeSaladsQue.offer(salad);
            if(vegetableQue.isEmpty()){
                break;
            }
        }
        if (!madeSaladsQue.isEmpty()) {
            System.out.println(madeSaladsQue.toString().replaceAll("\\[|,|\\]", ""));
        }
        if (!vegetableQue.isEmpty()) {
            System.out.println(vegetableQue.toString().replaceAll("\\[|,|\\]", ""));
        } else if (!caloriesStack.isEmpty()) {
            System.out.println(caloriesStack.toString().replaceAll("\\[|,|\\]", ""));
        }
    }
}
