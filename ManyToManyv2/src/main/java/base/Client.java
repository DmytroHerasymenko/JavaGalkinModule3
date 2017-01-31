package base;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 31.01.17.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ClientBank> clientBanks = new ArrayList<ClientBank>();

    public Client() {
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

    public List<ClientBank> getClientBanks() {
        return clientBanks;
    }

    public void setClientBanks(ClientBank clientBanks) {
        this.clientBanks.add(clientBanks);
    }

    public String getSurname() {
        return surname;
    }

    public void setBank(Bank bank) {
        ClientBank clientBank = new ClientBank();
        clientBank.setBank(bank);
        clientBank.setClient(this);
        clientBanks.add(clientBank);

    }

    public List<Bank> getBanks(){
        List<Bank> banks = new ArrayList<Bank>();
        for(ClientBank cb : clientBanks){
            banks.add(cb.getBank());
        }
        return banks;
    }



    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override

    public String toString() {
        return name + " " + surname;
    }
}
