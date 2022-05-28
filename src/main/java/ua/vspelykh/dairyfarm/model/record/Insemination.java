package ua.vspelykh.dairyfarm.model.record;


import ua.vspelykh.dairyfarm.model.entity.Cow;
import ua.vspelykh.dairyfarm.model.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "insemination")
public class Insemination extends AbstractRecord {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cow_id")
    private Cow cow;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public Insemination() {
    }

    public Insemination(LocalDateTime date, String comment) {
        super(date, comment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
