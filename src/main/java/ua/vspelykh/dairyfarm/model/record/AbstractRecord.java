package ua.vspelykh.dairyfarm.model.record;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractRecord)) return false;
        if (!super.equals(o)) return false;
        AbstractRecord that = (AbstractRecord) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date);
    }
}
