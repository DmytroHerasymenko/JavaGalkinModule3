import myUser.MyUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by dima on 24.01.17.
 */
public class Main {
    public static void main(String[] args) {
        StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder();
        ssr.configure("Hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssr1 = ssr.configure("Hibernate.cfg.xml");
        StandardServiceRegistry ss = ssr1.build();
        MetadataSources sf = new MetadataSources(ss);
        sf.buildMetadata();
        Metadata md = sf.buildMetadata();
        SessionFactory sessionFactory = md.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        MyUser myUser = new MyUser();
        myUser.setName("Igor");
        myUser.setSurname("Dub");
        session.save(myUser);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
