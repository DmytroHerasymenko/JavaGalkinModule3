import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dima on 19.01.17.
 */
public class DAOFactory {

    Connection con = null;
    private  static DAOFactory instance;
    private UserDAO userDAO;
    private DAOFactory(Connection con){
        this.con = con;
    }
    public static DAOFactory getInstance() throws ClassNotFoundException, SQLException {

        if (instance == null){
            //подгрузить драйвер постгрес
            Class.forName("org.postgresql.Driver");
            //new org.postgresql.Driver();

            String url = "jdbc:postgresql://127.0.0.1/myFirst";
            Connection con = DriverManager.getConnection(url, "postgres", "1");
            instance = new DAOFactory(con);
        }
        return instance;

    }

    public UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAOImpl(con);
        }
        return userDAO;
    }
}
