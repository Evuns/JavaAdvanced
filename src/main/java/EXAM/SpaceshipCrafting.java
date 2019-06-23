package EXAM;

import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queChemicals = new ArrayDeque<>();
        ArrayDeque<Integer> stackPhysical = new ArrayDeque<>();

        int[] chemicals = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int chemical : chemicals) {
            queChemicals.offer(chemical);
        }
        int[] physicals = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int physical : physicals) {
            stackPhysical.push(physical);
        }

        int glass = 25;
        int aluminium = 50;
        int lithium = 75;
        int carbonFiber = 100;

        TreeMap<String, List<Integer>> madeMaterials = new TreeMap<>();
        madeMaterials.put("aluminium", new ArrayList<>());
        madeMaterials.put("carbonFiber", new ArrayList<>());
        madeMaterials.put("glass", new ArrayList<>());
        madeMaterials.put("lithium", new ArrayList<>());

        while (!queChemicals.isEmpty() && !stackPhysical.isEmpty()) {
            int firstIngredient = queChemicals.poll();
            int secondIngredient = stackPhysical.pop();
            int sum = firstIngredient + secondIngredient;

            String name = material(sum);
            if (!name.equals("continue")) {
                madeMaterials.get(name).add(1);
            } else {
                secondIngredient += 3;
                while (name.equals("continue") && !queChemicals.isEmpty()) {
                    firstIngredient = queChemicals.poll();
                    sum = firstIngredient + secondIngredient;
                    name = material(sum);
                    secondIngredient += 3;
                }
                if (queChemicals.isEmpty()){
                    stackPhysical.push(secondIngredient);
                    break;
                }

                madeMaterials.get(name).add(1);
            }
        }
        if (madeMaterials.get("aluminium").size() != 0 && madeMaterials.get("carbonFiber").size() != 0 &&
                madeMaterials.get("glass").size() != 0 && madeMaterials.get("lithium").size() != 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (!queChemicals.isEmpty()) {
            System.out.println("Liquids left: " + queChemicals.toString().replaceAll("\\[|\\]", ""));
        } else {
            System.out.println("Liquids left: none");
        }

        if (!stackPhysical.isEmpty()) {
            System.out.println("Physical items left: " + stackPhysical.toString().replaceAll("\\[|\\]", ""));
        } else {
            System.out.println("Physical items left: none");
        }
        System.out.printf("Aluminium: %d%n" +
                        "Carbon fiber: %d%n" +
                        "Glass: %d%n" +
                        "Lithium: %d", madeMaterials.get("aluminium").size(), madeMaterials.get("carbonFiber").size(),
                madeMaterials.get("glass").size(), madeMaterials.get("lithium").size());


    }

    public static String material(int sum) {
        switch (sum) {
            case 25:
                return "glass";
            case 50:
                return "aluminium";
            case 75:
                return "lithium";
            case 100:
                return "carbonFiber";
            default:
                return "continue";
        }
    }
}
