package ua.infopulse.dao;

/**
 * Created by dima on 19.02.17.
 */
public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    private ClientDAO clientDAO = new ClientDAO();

    private DAOFactory( ) {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ClientDAO getClientDAO(){
        return clientDAO;
    }


}
