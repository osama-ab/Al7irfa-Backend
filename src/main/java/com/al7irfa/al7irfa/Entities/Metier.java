package com.al7irfa.al7irfa.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Metier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_metier;
    private String nom;
    private String description;

    @OneToOne(mappedBy = "metier")
    private Ouvrier ouvrier;


}
