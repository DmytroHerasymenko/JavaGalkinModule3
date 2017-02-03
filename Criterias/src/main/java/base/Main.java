package base;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by dima on 31.01.17.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Bank> criteriaQuery = criteriaBuilder.createQuery(Bank.class);

        Root<Bank> rootBank = criteriaQuery.from(Bank.class);

        criteriaQuery.select(rootBank);

        ParameterExpression<String> bankName = criteriaBuilder.parameter(String.class);
        criteriaQuery.where(criteriaBuilder.equal(rootBank.get(Bank_.name),bankName));

        TypedQuery<Bank> bankTypedQuery = entityManager.createQuery(criteriaQuery).setParameter(bankName, "Kreschatyk");
        Bank b = bankTypedQuery.getSingleResult();
        System.out.println(b.getName());

        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
