package ua.infopulse.service;

import ua.infopulse.clientDTO.ClientDTO;
import ua.infopulse.dao.ClientDAO;
import ua.infopulse.dao.DAOFactory;

/**
 * Created by dima on 21.02.17.
 */
public class LoginService {
    public ClientDTO loginVerify(String login, String password){
        DAOFactory factory = DAOFactory.getInstance();
        ClientDAO clientDAO = factory.getClientDAO();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setLogin(login);
        clientDTO.setPassword(password);
        return clientDAO.getClientDAOByLoginAndPassword(clientDTO);

    }
}
