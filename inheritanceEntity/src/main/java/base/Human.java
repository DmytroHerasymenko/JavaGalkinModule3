package base;

import org.hibernate.boot.registry.selector.spi.StrategySelector;

import javax.persistence.*;

/**
 * Created by dima on 31.01.17.
 */
@Entity
@Table(name = "humans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_human", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue(value = "human")
public class Human {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;

    public Human() {
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
}
