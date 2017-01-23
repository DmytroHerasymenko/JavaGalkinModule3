import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dima on 19.01.17.
 */
public class UserDAOImpl implements UserDAO {
    Connection con;
    final String sql = "SELECT * FROM my_users WHERE id = ?";

    UserDAOImpl(Connection con) {
        this.con = con;
    }

    public UserDTO getUserByID(int id) throws SQLException {
        UserDTO user = null;
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1,id);
        ResultSet rs = pr.executeQuery();
        while(rs.next()){
            user = new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getString("surname"));
        }
        return user;
    }
}
