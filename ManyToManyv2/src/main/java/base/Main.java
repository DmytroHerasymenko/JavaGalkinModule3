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

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        client1.setName("Igor");
        client2.setName("Ilya");
        client3.setName("Misha");
        client1.setSurname("Petrov");
        client2.setSurname("Ivanov");
        client3.setSurname("Grigoryev");

        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        Bank bank1 = new Bank();
        bank1.setName("Deutsche_Bank");
        Bank bank2 = new Bank();
        bank2.setName("Privat");

        entityManager.persist(bank1);
        entityManager.persist(bank2);

        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();

        ClientBank clientBank1 = new ClientBank();
        clientBank1.setBank(bank1);
        clientBank1.setClient(client1);
        client1.setClientBanks(clientBank1);
        bank1.setClientBanks(clientBank1);

        ClientBank clientBank2 = new ClientBank();
        clientBank2.setBank(bank1);
        clientBank2.setClient(client2);
        client2.setClientBanks(clientBank2);
        bank1.setClientBanks(clientBank2);

        ClientBank clientBank3 = new ClientBank();
        clientBank3.setBank(bank2);
        clientBank3.setClient(client3);
        client3.setClientBanks(clientBank3);
        bank2.setClientBanks(clientBank3);
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();


    }
}
