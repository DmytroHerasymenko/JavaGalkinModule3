package base;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by dima on 26.01.17.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        /*entityManager.getTransaction().begin();
        Address address1 = new Address();
        Address address2 = new Address();
        address1.setClientAddress("Universe");
        address2.setClientAddress("Selo");
        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        Client c1 = new Client();
        Client c2 = new Client();
        c1.setName("Vasyl");
        c2.setName("Petro");
        c1.setSurname("Pupko");
        c2.setSurname("Bulba");
        c1.setAddres(address1);
        c2.setAddres(address2);
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.getTransaction().commit();*/

        entityManager.getTransaction().begin();
        Client c3 = entityManager
                .createQuery("FROM base.Client p WHERE name=:clientName", Client.class)
                .setParameter("clientName", "Vasyl").getSingleResult();
        entityManager.getTransaction().commit();
        System.out.println(c3.getName());
        System.out.println(c3.getAddres().getClientAddress());

        entityManager.close();
        sessionFactory.close();
    }
}
