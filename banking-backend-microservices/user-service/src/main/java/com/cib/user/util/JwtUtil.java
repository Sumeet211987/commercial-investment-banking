// package com.cib.user.util;

// import java.security.Key;

// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.security.Keys;
// import lombok.Value;

// @Component
// public class JwtUtil {

//     @Value("${jwt.secret}")
//     private String secret;

//     public boolean validateToken(String token){
//         try {
//             Key key =Keys.hmacShaKeyFor(secret.getBytes());
//             Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//             return true;

//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }

// }
