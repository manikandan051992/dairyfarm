package ua.vspelykh.dairyfarm.model.entity;

import ua.vspelykh.dairyfarm.model.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    public static final String DELETE = "User.delete";
    public static final String BY_EMAIL = "User.getByEmail";
    public static final String ALL_SORTED = "User.getAllSorted";

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 128)
    private String name;

    @Column(name = "number", nullable = false)
    @NotBlank
    @Size(max = 13)
    private String number;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank
    @Size(max = 70)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 128)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
//    @BatchSize(size = 200)
    private Role role;

    @ManyToOne(optional = false)
    private Farm farm;

    public User() {
    }

    public User(String name, String number, String email, String password, Role role) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}