import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        List<Project> projects = entityManager.createQuery("FROM Project p" +
                " ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects.sort(Comparator.comparing(Project::getName));

        for (Project project : projects) {
            System.out.printf("Project name: %s%n", project.getName());
            System.out.printf("      Project Description: %s%n", project.getDescription());
            System.out.printf("      Project Start Date: %s%n", project.getStartDate());
            System.out.printf("      Project End Date: %s%n", project.getEndDate());

        }

        entityManager.close();
    }
}
