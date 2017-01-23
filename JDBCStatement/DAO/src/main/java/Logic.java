import java.sql.SQLException;

/**
 * Created by dima on 19.01.17.
 */
public class Logic {
    public void execute() throws SQLException, ClassNotFoundException {
        int id = 1;
        DAOFactory factory = DAOFactory.getInstance();

        UserDAO userDAO = factory.getUserDAO();
        UserDTO user = userDAO.getUserByID(id);
        System.out.println(user.getName());
    }
}




