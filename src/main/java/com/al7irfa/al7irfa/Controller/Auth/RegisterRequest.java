package com.al7irfa.al7irfa.Controller.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName ;
    private String lastName ;
    private String email ;
    private String password ;
    private String address;
    private String phone ;
}
