package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vaccines")
public class Vaccine extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "company", nullable = false)
    @NotNull
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
