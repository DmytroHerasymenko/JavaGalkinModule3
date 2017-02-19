package ua.infopulse.dao;

import ua.infopulse.client.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dima on 19.02.17.
 */
public class ClientDAO {

    public boolean insert(Client client) throws SQLException {

        String insertTableSQL = "INSERT INTO clients (name, login, password) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = DAOFactory.getInstance().getConnection().prepareStatement(insertTableSQL)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLogin());
            preparedStatement.setString(3, client.getPassword());

            preparedStatement.execute();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
