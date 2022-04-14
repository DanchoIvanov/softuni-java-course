import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("UPDATE Town t Set t.name = upper(t.name)" +
                " WHERE length(t.name) <= 5").executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
