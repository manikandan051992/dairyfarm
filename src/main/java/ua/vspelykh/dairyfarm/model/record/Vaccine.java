package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vaccines")
public class Vaccine extends AbstractBaseEntity {

    //TODO: feel columns
    private String name;

    private String company;

    public Vaccine(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public Vaccine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
