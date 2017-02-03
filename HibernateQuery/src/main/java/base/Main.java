package base;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 31.01.17.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        /*entityManager.getTransaction().begin();
        Human human1 = new Human();
        human1.setName("Vasyl");
        human1.setSurname("Vasylenko");
        Human human2 = new Human();
        human2.setName("Petro");
        human2.setSurname("Petrenko");
        Human human3 = new Human();
        human3.setName("Dmytro");
        human3.setSurname("Dmytrenko");
        entityManager.persist(human1);
        entityManager.persist(human2);
        entityManager.persist(human3);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Bank bank1 = new Bank();
        bank1.setName("Kreschatyk");
        List<Human> humans1  = new ArrayList<Human>();
        humans1.add(human1);
        humans1.add(human2);
        bank1.setHumans(humans1);

        Bank bank2 = new Bank();
        bank2.setName("Privat");
        List<Human> humans2  = new ArrayList<Human>();

        humans2.add(human3);
        bank1.setHumans(humans2);
        human1.setBank(bank1);
        human2.setBank(bank1);
        human3.setBank(bank2);
        entityManager.persist(bank1);
        entityManager.persist(bank2);
        entityManager.getTransaction().commit();*/

        entityManager.getTransaction().begin();
        Bank bank = entityManager.createQuery("SELECT b FROM base.Bank b JOIN b.humans h WHERE h.name=:name", Bank.class)
                .setParameter("name", "Vasyl").getSingleResult();
        entityManager.getTransaction().commit();
        System.out.println(bank.getName());

        entityManager.getTransaction().begin();
        int rows = entityManager.createQuery("UPDATE base.Human h SET h.surname =:surname WHERE h.name =:name")
                .setParameter("surname", "Ivanov")
                .setParameter("name", "Vasyl")
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println(rows);

        entityManager.getTransaction().begin();
        Integer bankName = (Integer) entityManager.createNativeQuery("SELECT id FROM banks WHERE name =:bankName")
                .setParameter("bankName", "Kreschatyk").getSingleResult();
        entityManager.getTransaction().commit();
        System.out.println(bankName);

        entityManager.getTransaction().begin();
        Query q = entityManager.createNamedQuery("myQuery", Bank.class);

        List<Bank> banks = q.getResultList();
        entityManager.getTransaction().commit();
        for (Bank b : banks) {
            System.out.println(b.getName());
        }

        entityManager.getTransaction().begin();
        Query q1 = entityManager.createNamedQuery("myNameQuery", Human.class);
        List<Human> humans = q1.getResultList();
        entityManager.getTransaction().commit();
        for (Human h : humans) {
            System.out.println(h.getName());
        }

        /*entityManager.getTransaction().begin();
        Human h1 = entityManager
                .createQuery("FROM base.Human p " +
                        "WHERE name=:p_name", Human.class)
                .setParameter("p_name", "Dmytro")
                .getSingleResult();
        entityManager.getTransaction().commit();

        System.out.println(h1.getSurname());

        entityManager.getTransaction().begin();
        Human h2 = entityManager.find(Human.class, 5);
        entityManager.getTransaction().commit();



        //System.out.println(h2.getSurname());*/

        //критерии



        entityManager.close();
        sessionFactory.close();
    }
}
