package com.al7irfa.al7irfa.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Reclamation;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;



    @OneToOne
    @JoinColumn(name = "id_ouvrier")
    private Ouvrier ouvrier;

    @OneToOne
    @JoinColumn(name = "id_consultation")
    private Consultation consultation ;


    private String commentaire;

}
