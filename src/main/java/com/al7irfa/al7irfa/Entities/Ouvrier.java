package com.al7irfa.al7irfa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Ouvrier extends User{


    @OneToOne
    @JoinColumn(name = "metier_id")
    private Metier metier;

    @OneToOne(mappedBy = "ouvrier")
    private Rating rating;

    @OneToMany(mappedBy = "ouvrier")
    private Collection<Consultation>consultations;

    @OneToOne(mappedBy = "ouvrier")
    private Reclamation reclamation;

    @OneToOne(mappedBy = "ouvrier")
    private Paiement paiement;



}
