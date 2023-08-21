package com.al7irfa.al7irfa.Controller.Auth;

import com.al7irfa.al7irfa.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String email ;
    private String password ;

}
