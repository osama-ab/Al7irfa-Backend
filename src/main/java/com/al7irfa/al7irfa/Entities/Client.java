
package com.al7irfa.al7irfa.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User{



    @OneToMany(mappedBy = "client")
    private Collection<Consultation>consultations;

    @OneToOne(mappedBy = "client")
    private Reclamation reclamation;

    @OneToOne(mappedBy = "client")
    private Paiement paiement;




}
