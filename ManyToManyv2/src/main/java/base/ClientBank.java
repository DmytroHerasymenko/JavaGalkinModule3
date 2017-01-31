package base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dima on 31.01.17.
 */

@Entity
@Table(name = "client_bank")
public class ClientBank implements Serializable{
    @Id
    @ManyToOne
    Bank bank;
    @Id
    @ManyToOne
    Client client;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
