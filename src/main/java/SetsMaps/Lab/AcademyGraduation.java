package SetsMaps.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberStudents = Integer.parseInt(scanner.nextLine());
        Map<String,Double> studentsScores = new TreeMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("#.###################");

        for (int i = 0; i < numberStudents ; i++) {
            String name = scanner.nextLine();
            double [] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double sum = 0;
            for (int j = 0; j < scores.length ; j++) {
                sum += scores[j];
            }

            studentsScores.put(name,sum / scores.length);
        }
       studentsScores.forEach((k,v) ->{
           System.out.printf("%s is graduated with %s\n",k,decimalFormat.format(v));
       });
    }
}
