
package com.al7irfa.al7irfa.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;
import java.util.List;

@Entity @Data

@PrimaryKeyJoinColumn(name = "user_id")

public class Client extends User{


    @Builder

public Client(int id , String fn ,String ln ,String email, String password ,
              String addresse , String phone , String cin
    , String pays  , String ville ,Role role) {
    super(  id ,  fn , ln , email,  password ,
                 addresse ,  phone ,  cin
                ,  pays  ,  ville , role);
}

    @OneToMany(mappedBy = "client")
    private Collection<Consultation>consultations;

    @OneToOne(mappedBy = "client")
    private Reclamation reclamation;

    @OneToOne(mappedBy = "client")
    private Paiement paiement;


    public Client() {

    }


}
