package base;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by dima on 31.01.17.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Human human1 = new Human();
        human1.setName("Petro");
        human1.setSurname("Petrenko");
        entityManager.persist(human1);

        Manager manager1 = new Manager();
        manager1.setName("Vasyl");
        manager1.setSurname("Vasylenko");
        manager1.setCompanyName("Tesla");
        entityManager.persist(manager1);
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
