package com.al7irfa.al7irfa.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rating;

    private int  note;

    @OneToOne
    @JoinColumn(name = "id_ouvrier")
    @JsonBackReference
    private Ouvrier ouvrier;









}
