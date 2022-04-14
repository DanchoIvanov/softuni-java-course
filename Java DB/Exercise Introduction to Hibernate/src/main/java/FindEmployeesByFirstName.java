import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine() +"%";

        List<Employee> employees = entityManager.createQuery("FROM Employee e" +
                " WHERE e.firstName LIKE :input", Employee.class)
                .setParameter("input", input)
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s - (%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
        }

        entityManager.close();
    }
}
