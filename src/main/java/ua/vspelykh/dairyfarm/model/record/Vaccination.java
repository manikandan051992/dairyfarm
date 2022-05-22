package ua.vspelykh.dairyfarm.model.record;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccination extends AbstractRecord {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vaccine vaccine;

    public Vaccination() {
    }

    public Vaccination(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
