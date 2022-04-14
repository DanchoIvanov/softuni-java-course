import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        List<String> resultList = entityManager.createQuery("SELECT e.firstName FROM Employee e" +
                " WHERE e.salary > 50000", String.class).getResultList();

        resultList.forEach(System.out::println);

        entityManager.close();
    }
}
