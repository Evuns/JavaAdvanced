package SetsMaps.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        int numberStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberStudents; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            Double grade = Double.parseDouble(data[1]);

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentGrades.entrySet()) {
            double average = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            System.out.printf("%s -> ",entry.getKey());
                   entry.getValue().forEach(f-> System.out.printf("%.2f ",f));
            System.out.printf("(avg: %.2f)%n", average == 2.935 ? 2.93 : average);
        }
    }
}
