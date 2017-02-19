package ua.infopulse.service;

import ua.infopulse.client.Client;
import ua.infopulse.dao.*;

import java.sql.SQLException;

/**
 * Created by dima on 16.02.17.
 */
public class RegistrationService {
    public boolean registrate(String name, String login, String password) throws SQLException, ClassNotFoundException {
        DAOFactory factory = DAOFactory.getInstance();
        ClientDAO clientDAO = factory.getClientDAO();
        Client client = new Client();
        client.setName(name);
        client.setLogin(login);
        client.setPassword(password);
        return clientDAO.insert(client);
    }
}
