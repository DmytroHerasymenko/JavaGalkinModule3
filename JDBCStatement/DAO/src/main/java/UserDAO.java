import java.sql.SQLException;

/**
 * Created by dima on 19.01.17.
 */
public interface UserDAO {
    UserDTO getUserByID(int id) throws SQLException;
}
