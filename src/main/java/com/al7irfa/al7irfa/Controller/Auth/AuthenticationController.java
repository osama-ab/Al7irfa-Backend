package com.al7irfa.al7irfa.Controller.Auth;

import com.al7irfa.al7irfa.Config.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service ;

    private final LogoutService logoutService ;
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

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Get the authenticated user's details

        // Call the logout service
      logoutService.logout(request, response, authentication);

        // Clear the security context
        SecurityContextHolder.clearContext();

        return ResponseEntity.ok("Logged out successfully");
    }



    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }







}
