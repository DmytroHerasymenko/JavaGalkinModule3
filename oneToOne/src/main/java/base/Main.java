package base;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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
        Client c3 = new Client();
        c3.setName("Vania");
        c3.setSurname("Ivanov");

        Manager m1 = new Manager();
        m1.setName("Manager1");
        Manager m2 = new Manager();
        m2.setName("Manager2");

        entityManager.getTransaction().begin();
        Address address1 = new Address();
        address1.setClient(c1);
        address1.setClientAddress("Universe");
        Address address2 = new Address();
        address2.setClient(c2);
        address2.setClientAddress("Selo");
        Address address3 = new Address();
        address3.setClient(c3);
        address3.setClientAddress("Kyiv");

        c1.setAddres(address1);
        c2.setAddres(address2);
        c3.setAddres(address3);

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(address3);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Client> clients1 = new ArrayList<Client>();
        clients1.add(c1);
        clients1.add(c2);
        m1.setClients(clients1);
        List<Client> clients2 = new ArrayList<Client>();
        clients2.add(c3);
        m2.setClients(clients2);
        entityManager.persist(m1);
        entityManager.persist(m2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Client c = entityManager
                .createQuery("FROM base.Client p WHERE name=:clientName", Client.class)
                .setParameter("clientName", "Vasyl").getSingleResult();
        entityManager.getTransaction().commit();

        System.out.println(c.getName());
        System.out.println(c.getAddres().getClientAddress());

        entityManager.getTransaction().begin();
        Address a = entityManager
                .createQuery("FROM base.Address p WHERE clientAddress=:addressName", Address.class)
                .setParameter("addressName", "Universe").getSingleResult();
        entityManager.getTransaction().commit();

        System.out.println(a.getClientAddress());
        System.out.println(a.getClient().getName());

        entityManager.getTransaction().begin();
        Manager m = entityManager
                .createQuery("FROM base.Manager m WHERE name=:managerName", Manager.class)
                .setParameter("managerName", "Manager1").getSingleResult();
        List<Client> managerClients = m.getClients();
        entityManager.getTransaction().commit();

        System.out.println(m.getName());
        for (Client cc: managerClients) {
            System.out.println(cc);
        }

        entityManager.close();
        sessionFactory.close();
    }
}
