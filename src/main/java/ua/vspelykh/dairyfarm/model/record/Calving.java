package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.entity.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calving")
public class Calving extends AbstractRecord {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cow cow;

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Calving{" +
                "cow=" + cow +
                ", user=" + user +
                '}';
    }
}
