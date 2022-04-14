import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        List<Department> departments = entityManager.createQuery("FROM Department d", Department.class).getResultList();

        for (Department department : departments) {
            Employee employee =  entityManager.createQuery("FROM Employee e" +
                    " WHERE e.department.name = :departmentName" +
                    " ORDER BY e.salary DESC", Employee.class)
                    .setParameter("departmentName", department.getName())
                    .setMaxResults(1)
                    .getSingleResult();

            if (employee.getSalary().longValue() < 30000 || employee.getSalary().longValue() > 70000) {
                System.out.printf("%s %.2f%n", department.getName(), employee.getSalary());

            }
        }

        entityManager.close();
    }
}
