import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String departments = "Engineering, Tool Design, Marketing, Information Services";

        entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12" +
                        " WHERE e.department.name IN (:departments)")
                .setParameter("departments", departments)
                .executeUpdate();

        entityManager.getTransaction().commit();

        List<Employee> employeeList = entityManager.createQuery("FORM Employee e" +
                        " WHERE e.departments.name IN (:departments)", Employee.class)
                .setParameter("departments", departments)
                .getResultList();

        employeeList.forEach(e -> System.out.printf("%s %s (%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));

        entityManager.close();
    }
}
