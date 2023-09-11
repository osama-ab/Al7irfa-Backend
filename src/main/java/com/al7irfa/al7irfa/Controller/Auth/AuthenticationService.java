package com.al7irfa.al7irfa.Controller.Auth;


import com.al7irfa.al7irfa.Config.JwtService;
import com.al7irfa.al7irfa.Entities.Client;
import com.al7irfa.al7irfa.Entities.Ouvrier;
import com.al7irfa.al7irfa.Entities.Role;
import com.al7irfa.al7irfa.Repository.ClientRepository;
import com.al7irfa.al7irfa.Repository.UserRepository;
import com.al7irfa.al7irfa.Token.Token;
import com.al7irfa.al7irfa.Token.TokenRepository;
import com.al7irfa.al7irfa.Token.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.al7irfa.al7irfa.Entities.User ;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final ClientRepository clientRepository;



    public AuthenticationResponse registerClient(RegisterRequest request) {

//        byte[] imageBytes = Base64.getDecoder().decode(request.getImage()); // Decode base64 string to byte array



        Client client = Client.builder()
                .id(request.getId())
                .fn(request.getFirstName())
                .ln(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .addresse(request.getAddress())
                .phone(request.getPhone())
                .cin(request.getCin())
                .pays(request.getPays())
                .ville(request.getVille())
                .role(Role.Client)
//                .image(imageBytes)
                .build();
        var savedUser = repository.save(client);
        var jwtToken = jwtService.generateToken(client);
        var refreshToken = jwtService.generateRefreshToken(client);
               saveUserToken(savedUser, jwtToken);








        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(Role.Client)
                .build();
    }



    public AuthenticationResponse registerOuvrier(RegisterRequest request) {

//        byte[] imageBytes = Base64.getDecoder().decode(request.getImage()); // Decode base64 string to byte array


        Ouvrier ouvrier = Ouvrier.builder()
                .id(request.getId())
                .fn(request.getFirstName())
                .ln(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .addresse(request.getAddress())
                .phone(request.getPhone())
                .cin(request.getCin())
                .pays(request.getPays())
                .ville(request.getVille())
                .role(Role.Ouvrier)
//                .image(imageBytes)
                .categorie(request.getCategorie())
                .build();
        var savedUser = repository.save(ouvrier);
        var jwtToken = jwtService.generateToken(ouvrier);
        var refreshToken = jwtService.generateRefreshToken(ouvrier);
        saveUserToken(savedUser, jwtToken);


        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(request.getRole())
                .build();
    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()


                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);


        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(user.getRole())
                .addresse(user.getAddress())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .cin(user.getCin())
                .phone(user.getPhone())
                .ville(user.getVille())
                .pays(user.getPays())
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }


}