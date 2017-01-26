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



        Client c1 = new Client();
        c1.setName("Vasyl");
        c1.setSurname("Pupko");
        Client c2 = new Client();
        c2.setName("Petro");
        c2.setSurname("Bulba");


        entityManager.getTransaction().begin();

        Address address1 = new Address();
        Address address2 = new Address();
        address1.setClient(c1);
        address2.setClient(c2);
        address1.setClientAddress("Universe");
        address2.setClientAddress("Selo");

        c1.setAddres(address1);
        c2.setAddres(address2);

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Client c3 = entityManager
                .createQuery("FROM base.Client p WHERE name=:clientName", Client.class)
                .setParameter("clientName", "Vasyl").getSingleResult();
        entityManager.getTransaction().commit();
        System.out.println(c3.getName());
        System.out.println(c3.getAddres().getClientAddress());

        entityManager.getTransaction().begin();
        Address a = entityManager
                .createQuery("FROM base.Address p WHERE clientAddress=:addressName", Address.class)
                .setParameter("addressName", "Universe").getSingleResult();
        entityManager.getTransaction().commit();
        System.out.println(a.getClientAddress());
        System.out.println(a.getClient().getName());

        entityManager.close();
        sessionFactory.close();
    }
}
