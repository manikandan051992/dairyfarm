package ua.vspelykh.dairyfarm.model.entity;

import org.hibernate.validator.constraints.Range;
import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;
import ua.vspelykh.dairyfarm.model.record.Calving;
import ua.vspelykh.dairyfarm.model.record.Insemination;
import ua.vspelykh.dairyfarm.model.record.Vaccination;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "cows")
public class Cow extends AbstractBaseEntity {

    @Column(name = "number", nullable = false, unique = true)
    @Size(max = 8)
    private String number;

    @Column(name = "birth", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime birth;

    @Column(name = "is_alive", nullable = false, columnDefinition = "bool default true")
    private boolean isAlive;

    @Column(name = "death")
    private LocalDateTime death;

    @Column(name = "section", nullable = false)
    @Range(max = 1000)
    private Integer section;

    @Column(name = "lactation")
    private Integer lactation;

    @Column(name = "is_milking", nullable = false)
    @NotNull
    private boolean isMilking;

    @Column(name = "is_inseminated", nullable = false)
    @NotNull
    private boolean isInseminated;

    @OneToMany(mappedBy = "cow")
    private Collection<Vaccination> vaccinations;

    public Cow() {
    }

    public Cow(String number, LocalDateTime birth, Integer section, boolean isMilking) {
        this.number = number;
        this.birth = birth;
        this.section = section;
        this.isMilking = isMilking;
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public LocalDateTime getDeath() {
        return death;
    }

    public void setDeath(LocalDateTime death) {
        this.death = death;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getLactation() {
        return lactation;
    }

    public void setLactation(Integer lactation) {
        this.lactation = lactation;
    }

    public boolean isMilking() {
        return isMilking;
    }

    public void setMilking(boolean milking) {
        isMilking = milking;
    }

    public boolean isInseminated() {
        return isInseminated;
    }

    public void setInseminated(boolean inseminated) {
        isInseminated = inseminated;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Farm farm;

    @OneToMany(mappedBy = "cow")
    private Collection<Insemination> inseminations;

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Collection<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(Collection<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }


    public Collection<Insemination> getInseminations() {
        return inseminations;
    }

    public void setInseminations(Collection<Insemination> inseminations) {
        this.inseminations = inseminations;
    }

    @OneToMany(mappedBy = "cow")
    private Collection<Calving> calvings;

    public Collection<Calving> getCalvings() {
        return calvings;
    }

    public void setCalvings(Collection<Calving> calvings) {
        this.calvings = calvings;
    }
}
