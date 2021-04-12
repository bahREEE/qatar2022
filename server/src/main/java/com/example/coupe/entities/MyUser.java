package com.example.coupe.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserTBL",
    uniqueConstraints = { 
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") 
    })
public class MyUser {
    
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<MyRole> roles = new HashSet<>();

}
