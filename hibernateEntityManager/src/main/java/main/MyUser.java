package main;

import javax.persistence.*;

/**
 * Created by dima on 24.01.17.
 */

@Entity(name = "my_users")
public class MyUser {
    @Id
    @GeneratedValue
    int id;
    //@Column(name = "name")
    String name;
    //@Column(name = "surname")
    String surname;

    public MyUser() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
