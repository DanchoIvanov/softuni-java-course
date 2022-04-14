import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");
        String firstName = name[0];
        String lastName = name[1];

        Long count = entityManager.createQuery("SELECT count(e) FROM Employee e" +
                " WHERE firstName = :first_name" +
                " AND lastName = :last_name", Long.class)
                .setParameter("first_name", firstName)
                .setParameter("last_name", lastName).getSingleResult();

        System.out.println(count > 0 ? "Yes" : "No");

        entityManager.close();

    }
}
