package main;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by dima on 24.01.17.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory)Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();
        /*entityManager.getTransaction().begin();

        MyUser myUser = new MyUser();
        myUser.setName("Valera");
        myUser.setSurname("Val");
        entityManager.persist(myUser);
        entityManager.getTransaction().commit();*/

        entityManager.getTransaction().begin();
        List<MyUser> m = entityManager
                .createQuery("FROM main.MyUser p " +
                        "WHERE name=:p_name", MyUser.class)
                .setParameter("p_name", "Valera").getResultList();
        for(MyUser mm : m){
            System.out.println(mm.getName());
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();

    }
}
