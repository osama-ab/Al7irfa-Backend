package com.al7irfa.al7irfa.Controller.Auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service ;
    @PostMapping("/register/client")
    public ResponseEntity<AuthenticationResponse> registerClient(@RequestBody
                                                               RegisterRequest request ){

            return ResponseEntity.ok(service.registerClient(request));
    }


    @PostMapping("/register/ouvrier")
    public ResponseEntity<AuthenticationResponse> registerOuvrier(@RequestBody
                                                           RegisterRequest request ){

        return ResponseEntity.ok(service.registerOuvrier(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody
                                                           AuthenticationRequest request ){

        return ResponseEntity.ok(service.authenticate(request));

    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }







}
