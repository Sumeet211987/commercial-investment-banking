package com.cib.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cib.user.service.UserService;
import com.cib.user.dto.Customer;
import com.cib.user.dto.CustomerDto;
import com.cib.user.mapper.UserMapper;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    private static final String AUTH_SERVICE_URL = "http://localhost:8082/api/auth";

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestHeader("Authorization") String accessToken, @RequestBody CustomerDto customerDto) {
        if (!validateAccessToken(accessToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired access token");
        }
        Customer customer = userMapper.toEntity(customerDto);
        return ResponseEntity.ok(userMapper.toDto(userService.registerCustomer(customer)));
    }

    private boolean validateAccessToken(String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> body = new HashMap<>();
            body.put("token", token.replace("Bearer ", ""));
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<Boolean> response = restTemplate.postForEntity(AUTH_SERVICE_URL + "/validate", entity, Boolean.class);
            return response.getBody() != null && response.getBody();
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(userMapper.toDto(userService.updateCustomer(id,customerDto)));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Optional<Customer> customer =userService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        userService.deleteCustomer(id);
        return ResponseEntity.ok("Customer Details Deleted Successfully");
    }

     // POST: Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String>  credentials) {
        return restTemplate.postForEntity(AUTH_SERVICE_URL + "/login", credentials, Map.class);
    }

    // POST: Logout
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String accessToken) {
        Map<String,String> body = new HashMap<>();
        body.put("token", accessToken.replace("Bearer ", ""));
        return restTemplate.postForEntity(AUTH_SERVICE_URL + "/logout", body, String.class);
    }

}