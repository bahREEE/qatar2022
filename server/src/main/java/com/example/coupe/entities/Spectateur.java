package com.example.coupe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SpectateurTBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Spectateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spectateurUsername;

    private String spectateurFirstName;

    private String spectateurlastName;

    private String spectateuraddress;

    @Email
    private String spectateurEmail;

   


}
