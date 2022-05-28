package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calving")
public class Calving extends AbstractRecord {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cow_id")
    private Cow cow;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Calving() {
    }

    public Calving(LocalDateTime date, String comment) {
        super(date, comment);
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

    @Override
    public String toString() {
        return "Calving{" +
                "date=" + date +
                ", comment='" + comment + '\'' +
                ", cow=" + cow +
                '}';
    }
}
