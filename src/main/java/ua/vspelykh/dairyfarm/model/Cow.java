package ua.vspelykh.dairyfarm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cows")
public class Cow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String number;

    @Column
    private LocalDateTime birth;

    @Column
    private Integer section;

    @Column(name = "is_milking")
    private boolean isMilking;

    public Cow() {
    }

    public Cow(String number, LocalDateTime birth, Integer section, boolean isMilking) {
        this.number = number;
        this.birth = birth;
        this.section = section;
        this.isMilking = isMilking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public boolean isMilking() {
        return isMilking;
    }

    public void setMilking(boolean milking) {
        isMilking = milking;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", birth=" + birth +
                ", section=" + section +
                ", isMilking=" + isMilking +
                '}';
    }
}
