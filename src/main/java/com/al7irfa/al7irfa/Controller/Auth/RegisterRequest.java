package com.al7irfa.al7irfa.Controller.Auth;


import com.al7irfa.al7irfa.Entities.Categorie;
import com.al7irfa.al7irfa.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private int id;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private String address;
    private String phone ;
    private String cin ;
    private String ville ;
    private String pays ;
//    private byte[] image ;
    private Role role ;

    private Categorie categorie ;
}
