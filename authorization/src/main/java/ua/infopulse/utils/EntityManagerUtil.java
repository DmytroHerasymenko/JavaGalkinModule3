package ua.infopulse.utils;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by dima on 21.02.17.
 */
public final class EntityManagerUtil {
    private static SessionFactory sessionFactory =
            (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");

    private EntityManagerUtil(){
    }

    public static EntityManager getEntityManger(){
        return sessionFactory.createEntityManager();
    }

    public static void close(){
        sessionFactory.close();
    }

}
