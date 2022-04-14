package company_roster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> department = new ArrayList<>();

    public String getName() {
        return name;
    }

    public double getAverageSalary(){
        return department.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public List<Employee> getDepartment() {
        return department;
    }
}

