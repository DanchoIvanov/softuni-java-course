import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        List<Address> addresses = entityManager
                .createQuery("FROM Address a" +
                        " ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            if (address.getTown() == null) {
                System.out.printf("%s - %d employees%n", address.getText(), address.getEmployees().size());
            } else {
                System.out.printf("%s, %s - %d employees%n", address.getText(), address.getTown().getName(), address.getEmployees().size());
            }
        }

        entityManager.close();

    }
}
