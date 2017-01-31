package base;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 31.01.17.
 */
public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Client client1 = new Client();
        client1.setName("Vasa");
        client1.setSurname("Vasin");
        Client client2 = new Client();
        client2.setName("Peta");
        client2.setSurname("Petin");
        Client client3 = new Client();
        client3.setName("Sidor");
        client3.setSurname("Sid");
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();
        bank1.setName("Kreschatik");
        bank2.setName("Mykhuilivsky");
        List<Client> clients1 = new ArrayList<Client>();
        clients1.add(client1);
        clients1.add(client2);
        List<Client> clients2 = new ArrayList<Client>();
        clients2.add(client3);
        bank1.setClients(clients1);
        bank2.setClients(clients2);
        entityManager.persist(bank1);
        entityManager.persist(bank2);
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();

    }
}
