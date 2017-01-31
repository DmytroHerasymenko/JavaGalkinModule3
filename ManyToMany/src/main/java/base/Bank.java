package base;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 31.01.17.
 */
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "bank_name")
    String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Client> clients = new ArrayList<Client>();

    public Bank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
