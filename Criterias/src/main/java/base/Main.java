package base;

import base.Bank_;
import base.Human_;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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

        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder1 = entityManager.getCriteriaBuilder();

        CriteriaQuery<Bank> criteriaQuery1 = criteriaBuilder1.createQuery(Bank.class);
        Root<Bank> rootBank1 = criteriaQuery1.from(Bank.class);
        criteriaQuery1.select(rootBank1);

        ParameterExpression<String> clientName = criteriaBuilder1.parameter(String.class);

        Join<Bank,Human> bankHumanJoin = rootBank1.join(Bank_.humans);
        criteriaQuery1.where(criteriaBuilder1
                .equal(bankHumanJoin.get(Human_.name), clientName));

        TypedQuery<Bank> bankTypedQuery1 = entityManager.createQuery(criteriaQuery1).setParameter(clientName,"Vasyl");
        final List<Bank> banks = bankTypedQuery1.getResultList();
        for (Bank bb: banks) {
            System.out.println(bb.getName());
        }
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder2 = entityManager.getCriteriaBuilder();

        CriteriaQuery<Bank> criteriaQuery2 = criteriaBuilder2.createQuery(Bank.class);
        Root<Bank> rootBank2 = criteriaQuery2.from(Bank.class);

        Subquery<Integer> subquery = criteriaQuery2.subquery(Integer.class);
        Root<Human> humanRoot2 = subquery.from(Human.class);
        Join<Human, Bank> join1 = humanRoot2.join(Human_.bank);

        subquery.select(join1.get(Bank_.id)).where(criteriaBuilder2
                .equal(humanRoot2.get(Human_.name), criteriaBuilder2.parameter(String.class, "name")));

        criteriaQuery2.select(rootBank2).where(criteriaBuilder2.in(rootBank2.get(Bank_.id)).value(subquery));
        TypedQuery<Bank> bankTypedQuery2 = entityManager.createQuery(criteriaQuery2).setParameter("name","Vasyl");
        final List<Bank> banks2 = bankTypedQuery2.getResultList();
        for (Bank bb: banks2) {
            System.out.println(bb.getName());
        }


        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
