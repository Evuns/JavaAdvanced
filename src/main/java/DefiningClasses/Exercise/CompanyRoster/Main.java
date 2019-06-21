package DefiningClasses.Exercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Departments> departmentList = new HashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String department = data[3];
            Employee employee = new Employee(data[0],
                    Double.parseDouble(data[1]),
                    data[2]);

            if (data.length >= 5) {
                if (Character.isDigit(data[4].charAt(0))) {
                    employee.setAge(Integer.parseInt(data[4]));
                } else {
                    employee.setEmail(data[4]);
                }
            }
            if (data.length == 6) {
                employee.setAge(Integer.parseInt(data[5]));
            }

            if (!departmentList.containsKey(department)) {
                departmentList.put(department, new Departments());
            }
            departmentList.get(department).addEmployee(employee);
        }

        departmentList.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue().getAverageSalary(),
                        a.getValue().getAverageSalary()))
                .limit(1).forEach(entry -> {
            System.out.println(String.format("Highest Average Salary: %s", entry.getKey()));
            entry.getValue().getEmployees().stream()
                    .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                    .forEach(employee -> {
                        System.out.println(String.format("%s %.2f %s %d", employee.getName()
                                , employee.getSalary(), employee.getEmail(),
                                employee.getAge()
                        ));
                    });
        });

    }
}

