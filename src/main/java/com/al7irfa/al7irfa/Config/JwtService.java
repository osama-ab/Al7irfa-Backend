package com.al7irfa.al7irfa.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {

    private static final String SECRET_KEY = "68410a9b47557b2cbb81a80abeb2d7e2b88c3c4a1c6735e765c6fb5d0b1e05e6";
    public String extractUsername(String token) {

        extractClaim(token,Claims::getSubject);
        return null;

    }
    public <T> T extractClaim(String token , Function<Claims,T> claimsResolver ){

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails ){

        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(
            Map<String ,Object> extraClaims,
            UserDetails userDetails
    ){
     return Jwts.builder().
             setClaims(extraClaims).
             setSubject(userDetails.getUsername()).
             setIssuedAt(new Date(System.currentTimeMillis())).
             setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24)).
             signWith(SignatureAlgorithm.HS256, getSignInKey()).compact();


    }

    public boolean isTokenValid(String token , UserDetails userDetails){

        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) ) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
         return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {

        return extractClaim(token,Claims::getExpiration);
    }


    private Claims extractAllClaims(String token){
        return Jwts.parser().
                setSigningKey(getSignInKey()).
                parseClaimsJwt(token)
                .getBody();



    }

    private SecretKey getSignInKey() {


        // Convert the base64-encoded secret key to a byte array
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);

        // Use a specific algorithm (e.g., HmacSHA256) to create the SecretKey object
        SecretKey hmacKey = new SecretKeySpec(keyBytes, "HmacSHA256");

        return hmacKey;
    }

}
