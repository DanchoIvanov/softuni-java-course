package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployeeList() {
        return employees;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employees = employeeList;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee (Employee employee){
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee (String name){
        Employee employee = getEmployee(name);
        if (employee != null){
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public Employee getEmployee (String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public Employee getOldestEmployee(){
        int index = 0;
        int age = Integer.MIN_VALUE;
        for (int i = 0; i < employees.size(); i++) {
            Employee currentEmployee = employees.get(i);
            if (currentEmployee.getAge() > age){
                age = currentEmployee.getAge();
                index = i;
            }
        }
        return employees.get(index);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        employees.forEach(n -> sb.append(n + System.lineSeparator()));
        return String.format("Employees working at Cafe %s:%n%s", this.name, sb.toString().trim());
    }
}
