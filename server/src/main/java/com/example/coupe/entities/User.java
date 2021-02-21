package com.example.coupe.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserTBL")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	protected Long userId;
    @NotBlank(message = "The username field is required")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "The password field is required")
    private String password;
    @Email
    @NotEmpty(message = "An email is required")
    private String email;
    private Instant creationDate;
    private Boolean activated;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull
    private Collection<MyRole> roles = new ArrayList<>();

}
