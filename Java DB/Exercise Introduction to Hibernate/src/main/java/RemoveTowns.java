import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();

        entityManager.getTransaction().begin();

        int rows = entityManager.createQuery("DELETE FROM Address a" +
                " WHERE a.town.name = :town_name")
                .setParameter("town_name", town)
                .executeUpdate();

        entityManager.createQuery("DELETE FROM Town t" +
                        " WHERE a.town.getName = :townName")
                .setParameter("town_name", town)
                .executeUpdate();

        if (rows > 1) {
            System.out.printf("%d addresses in %s deleted", rows, town);
        } else if (rows == 1) {
            System.out.printf("%d address in %s deleted", rows, town);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
