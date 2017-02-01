package base;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dima on 31.01.17.
 */
@Entity
@Table(name = "managers")
@DiscriminatorValue(value = "manager")
public class Manager extends Human {
    @Column(name = "company_name")
    String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
