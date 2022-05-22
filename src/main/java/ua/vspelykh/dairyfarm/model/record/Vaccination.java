package ua.vspelykh.dairyfarm.model.record;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "vaccinations")
public class Vaccination extends AbstractRecord {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vaccine vaccine;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cow cow;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

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


    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
