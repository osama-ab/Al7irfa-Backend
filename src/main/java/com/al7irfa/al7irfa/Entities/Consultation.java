package com.al7irfa.al7irfa.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;



@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsultation;
    private Date consultationDate;

    private String description ;

    private Boolean isConfirmed ;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    @JsonBackReference
    private Ouvrier ouvrier;

    @OneToOne
    @JoinColumn(name = "idReview")
    private Review review;

    @OneToOne(mappedBy = "consultation")
    private Reclamation reclamation;


    private Integer note;



    @OneToOne
    @JoinColumn(name = "id_type_cons")
    private TypeConsultation typecons;

}
