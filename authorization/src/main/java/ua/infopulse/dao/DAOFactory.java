package ua.infopulse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dima on 19.02.17.
 */
public class DAOFactory {
    private final Connection connection;
    private static DAOFactory instance;
    private ClientDAO clientDAO;

    private DAOFactory(Connection connection) {
        this.connection = connection;
    }

    public static DAOFactory getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null){
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://127.0.0.1/authorization";
            Connection connection = DriverManager.getConnection(url, "postgres", "1");
            instance = new DAOFactory(connection);
        }
        return instance;
    }

    public ClientDAO getClientDAO(){
        if(clientDAO == null){
            clientDAO = new ClientDAO();
        }
        return clientDAO;
    }

    public Connection getConnection() {
        return connection;
    }
}
