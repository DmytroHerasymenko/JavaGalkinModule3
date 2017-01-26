package base;

import javax.persistence.*;

/**
 * Created by dima on 26.01.17.
 */
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "clientAddress")
    String clientAddress;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}
