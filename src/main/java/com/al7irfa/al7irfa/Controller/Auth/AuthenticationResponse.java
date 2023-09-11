package com.al7irfa.al7irfa.Controller.Auth;

import com.al7irfa.al7irfa.Entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("role")
    private Role role ;

    @JsonProperty("firstname")
    private String firstname ;

    @JsonProperty("lastname")
    private String lastname ;

    @JsonProperty("email")
    private String email ;

    @JsonProperty("phone")
    private String phone ;

    @JsonProperty("pays")
    private String pays ;

    @JsonProperty("ville")
    private String ville ;

    @JsonProperty("cin")
    private String cin ;

    @JsonProperty("addresse")
    private String addresse ;




}
