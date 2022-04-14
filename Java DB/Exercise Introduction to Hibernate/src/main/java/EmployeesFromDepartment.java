import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        String departmentName = "Research and Development";

        List<Employee> employeeList =  entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.department.name = :department_name" +
                " ORDER BY e.salary, e.id", Employee.class)
                .setParameter("department_name", departmentName)
                .getResultList();

        employeeList.forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

        entityManager.close();
    }
}
