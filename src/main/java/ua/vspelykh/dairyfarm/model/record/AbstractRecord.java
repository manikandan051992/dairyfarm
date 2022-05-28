package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractRecord extends AbstractBaseEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    protected LocalDateTime date;

    @Column(name = "comment")
    protected String comment;



    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AbstractRecord() {
    }

    public AbstractRecord(LocalDateTime date, String comment) {
        this.date = date;
        this.comment = comment;
    }
}
