package com.al7irfa.al7irfa.Entities;

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

    private String Description ;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
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
