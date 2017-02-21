package ua.infopulse.dao;

import ua.infopulse.clientDTO.ClientDTO;
import ua.infopulse.domain.Client;
import ua.infopulse.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Created by dima on 19.02.17.
 */
public class ClientDAO {

    public boolean insert(ClientDTO clientDTO) {
        EntityManager entityManager = EntityManagerUtil.getEntityManger();
        try {
            entityManager.getTransaction().begin();
            Client client = new Client();
            client.setName(clientDTO.getName());
            client.setLogin(clientDTO.getLogin());
            client.setPassword(clientDTO.getPassword());
            entityManager.persist(client);
            entityManager.getTransaction().commit();
            return true;
            //get specialize exception!!!!
        } catch (Exception e){
            return false;
        } finally {
            entityManager.close();
        }
    }

    public ClientDTO getClientDAOByLoginAndPassword(ClientDTO clientDTO){
        EntityManager entityManager = EntityManagerUtil.getEntityManger();
        Client client = null;
        try {
            entityManager.getTransaction().begin();
            client = entityManager
                    .createQuery("SELECT c FROM ua.infopulse.domain.Client c WHERE c.login = :login AND c.password = :password", Client.class)
                    .setParameter("login", clientDTO.getLogin())
                    .setParameter("password", clientDTO.getPassword())
                    .getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException e){
            client = null;
        }
        entityManager.close();

        if(client != null) {
            return clientDTO;
        } else {
            return null;
        }
    }
}
