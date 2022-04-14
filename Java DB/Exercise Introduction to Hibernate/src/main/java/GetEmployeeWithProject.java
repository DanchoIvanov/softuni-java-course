import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        int id = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery("FROM Employee e" +
                " WHERE e.id = :_id", Employee.class)
                .setParameter("_id", id)
                .getSingleResult();

        Set<Project> projects = employee.getProjects();

        List<String> sortedProjectNames = new ArrayList<>();

        for (Project project : projects) {
            sortedProjectNames.add(project.getName());
        }

        Collections.sort(sortedProjectNames);

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        sortedProjectNames.forEach(p -> System.out.println("      " + p));

        entityManager.close();
    }
}
