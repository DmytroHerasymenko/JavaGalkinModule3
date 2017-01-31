package base;

import javax.persistence.*;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    Address addres;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    Manager manager;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddres() {
        return addres;
    }

    public void setAddres(Address addres) {
        this.addres = addres;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override

    public String toString() {
        return name + " " + surname;
    }
}
