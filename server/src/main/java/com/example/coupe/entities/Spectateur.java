package com.example.coupe.entities;

import java.time.Instant;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "SpectateurTBL")
public class Spectateur extends User {

    private String spectateurUsername;

    private String spectateurFirstName;

    private String spectateurlastName;

    private String spectateuraddress;

    @Email
    private String spectateurEmail;

    public Spectateur(Long userId, String username, String password, String email, Instant creationDate,
            Boolean activated, Collection<MyRole> roles) {
        super(userId, username, password, email, creationDate, activated, roles);
    }

    public Spectateur() {
    }

    public Spectateur(Long userId, String username, String password, String email, Instant creationDate,
            Boolean activated, Collection<MyRole> roles, String spectateurUsername, String spectateurFirstName,
            String spectateurlastName, String spectateuraddress, @Email String spectateurEmail) {
        super(userId, username, password, email, creationDate, activated, roles);
        this.spectateurUsername = spectateurUsername;
        this.spectateurFirstName = spectateurFirstName;
        this.spectateurlastName = spectateurlastName;
        this.spectateuraddress = spectateuraddress;
        this.spectateurEmail = spectateurEmail;
    }

    public Spectateur(String spectateurUsername, String spectateurFirstName, String spectateurlastName,
            String spectateuraddress, @Email String spectateurEmail) {
        this.spectateurUsername = spectateurUsername;
        this.spectateurFirstName = spectateurFirstName;
        this.spectateurlastName = spectateurlastName;
        this.spectateuraddress = spectateuraddress;
        this.spectateurEmail = spectateurEmail;
    }

    public String getSpectateurUsername() {
        return spectateurUsername;
    }

    public void setSpectateurUsername(String spectateurUsername) {
        this.spectateurUsername = spectateurUsername;
    }

    public String getSpectateurFirstName() {
        return spectateurFirstName;
    }

    public void setSpectateurFirstName(String spectateurFirstName) {
        this.spectateurFirstName = spectateurFirstName;
    }

    public String getSpectateurlastName() {
        return spectateurlastName;
    }

    public void setSpectateurlastName(String spectateurlastName) {
        this.spectateurlastName = spectateurlastName;
    }

    public String getSpectateuraddress() {
        return spectateuraddress;
    }

    public void setSpectateuraddress(String spectateuraddress) {
        this.spectateuraddress = spectateuraddress;
    }

    public String getSpectateurEmail() {
        return spectateurEmail;
    }

    public void setSpectateurEmail(String spectateurEmail) {
        this.spectateurEmail = spectateurEmail;
    }

 
       


}
