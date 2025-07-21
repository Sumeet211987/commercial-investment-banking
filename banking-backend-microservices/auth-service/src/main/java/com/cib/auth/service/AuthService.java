package com.cib.auth.service;

import com.cib.auth.dto.*;
//import com.cib.auth.kafka.KafkaProducerService;
import com.cib.auth.service.JwtUtil;
import com.cib.auth.constants.SecurityConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;
//	private final KafkaProducerService kafkaProducerService;



	public LoginResponse login(LoginRequest request) {
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getUsername(), request.getPassword())
	    );

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

	    // 👇 Fetch the User entity to get the userId
	    User user = ((UserDetailsServiceImpl) userDetailsService).loadUserEntityByUsername(userDetails.getUsername());

	    String token = jwtUtil.generateToken(userDetails);
	    long expiry = jwtUtil.getExpirationInMillis();

	    return new LoginResponse(
	        token,
	        expiry,
	        userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()).toList(),
	        user.getId() // 👈 Set the user ID in the response
	    );
	}

    public void logout(String token) {
        // Stateless: Logout can just be a client-side token delete
        // Or blacklist token in DB (optional, not implemented here)
    	log.info("User logged out. Token: {}", token);
//    	kafkaProducerService.publishAuthEvent("auth-events", "User logged out. Token: " + token);
    }

    public LoginResponse refreshToken(String refreshToken) {
        if (!jwtUtil.isTokenValid(refreshToken)) {
            throw new RuntimeException("Invalid or expired refresh token");
        }
        String username = jwtUtil.extractUsername(refreshToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        User user = ((UserDetailsServiceImpl) userDetailsService).loadUserEntityByUsername(username); // 👈 Add this

        String newAccessToken = jwtUtil.generateToken(userDetails);
        long expiry = jwtUtil.getExpirationInMillis();

        return new LoginResponse(
            newAccessToken,
            expiry,
            userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()).toList(),
            user.getId() // 👈 Return userId here too
        );
    }


    public RoleResponse getUserRoles(Long userId) {
        // You should fetch roles from UserService or local DB if cached
        // Here we simulate response for simplicity
        List<String> roles = List.of("ROLE_USER");
//        kafkaProducerService.publishAuthEvent("auth-events", "Roles retrieved for user ID: " + userId);
        return new RoleResponse(userId, roles);
    }
}