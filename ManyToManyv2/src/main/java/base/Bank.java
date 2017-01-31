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
    @OneToMany(mappedBy = "bank",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<ClientBank> clientBanks = new ArrayList<ClientBank>();

    /*public void setClient(Client client) {
        ClientBank cb = new ClientBank();
        cb.setBank(this);
        cb.setClient(client);
        clientBanks.add(cb);
    }
    public List<Client> getClients(){
        List<Client> clients = new ArrayList<Client>();
        for(ClientBank cb: clientBanks){
            clients.add(cb.getClient());
        }
        return clients;
    }*/

    public List<ClientBank> getClientBanks() {
        return clientBanks;
    }

    public void setClientBanks(ClientBank clientBanks) {
        this.clientBanks.add(clientBanks);
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

    public Bank() {
    }
}
