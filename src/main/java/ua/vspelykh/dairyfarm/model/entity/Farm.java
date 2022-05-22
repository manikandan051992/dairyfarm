package ua.vspelykh.dairyfarm.model.entity;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
@Table(name = "farms")
public class Farm extends AbstractBaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @Size(max = 128)
    private String name;

    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String email;


    @Column(name = "address", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String address;

    @Column(name = "owner", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String owner;

    @OneToMany(mappedBy = "farm")
    private Collection<User> users;

    @OneToMany(mappedBy = "farm")
    private Collection<Cow> cows;

    public Farm() {
    }

    public Farm(String name, String email, String address, String owner) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Cow> getCows() {
        return cows;
    }

    public void setCows(Collection<Cow> cows) {
        this.cows = cows;
    }
}
