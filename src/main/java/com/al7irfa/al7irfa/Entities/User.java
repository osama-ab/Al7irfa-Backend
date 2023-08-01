package com.al7irfa.al7irfa.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private int id_user;
    private String nom;
    private String prenom;
    private String address;
    private String phone ;




}
