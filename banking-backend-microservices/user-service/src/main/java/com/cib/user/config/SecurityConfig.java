// package com.cib.user.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf().disable()
//             .authorizeHttpRequests(auth->auth
//             .requestMatchers("/api/users/register").permitAll()
//             .requestMatchers("/api/users/*").permitAll() // allow unauthenticated access
//             .anyRequest().authenticated())
//             .httpBasic(Customizer.withDefaults()); // disable form-based login for APIs

//         return http.build();
//     }
// }

