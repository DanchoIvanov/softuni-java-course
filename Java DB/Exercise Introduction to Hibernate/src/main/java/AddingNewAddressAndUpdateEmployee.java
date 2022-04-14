import entities.Address;
import entities.Employee;

import javax.persistence.*;
import java.util.Scanner;

public class AddingNewAddressAndUpdateEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        String lastName = scanner.nextLine();

        try {
            Employee employee = entityManager
                    .createQuery("SELECT e FROM Employee e" +
                            " WHERE e.lastName = :last_name", Employee.class)
                    .setParameter("last_name", lastName)
                    .getSingleResult();

            Address address = new Address();
            String addressText = "Vitoshka 15";
            address.setText(addressText);
            entityManager.persist(address);

            employee.setAddress(address);
            entityManager.persist(employee);

            entityManager.getTransaction().commit();

        } catch (NoResultException | NonUniqueResultException e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();

    }
}
