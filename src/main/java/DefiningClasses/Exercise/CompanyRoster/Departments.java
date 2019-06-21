package DefiningClasses.Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    private List<Employee> employees;

    public Departments(){
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public double getAverageSalary(){
        return  this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().getAsDouble();
    }
}
