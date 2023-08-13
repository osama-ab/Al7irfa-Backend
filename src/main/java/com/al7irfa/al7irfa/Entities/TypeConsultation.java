package com.al7irfa.al7irfa.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeConsultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_cons;
    
    @OneToOne(mappedBy = "typecons")
    private Consultation consultation;
}
