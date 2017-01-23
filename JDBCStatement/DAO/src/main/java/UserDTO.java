/**
 * Created by dima on 19.01.17.
 */
public class UserDTO {
    int id;
    String name;
    String surname;

    public UserDTO(int id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
