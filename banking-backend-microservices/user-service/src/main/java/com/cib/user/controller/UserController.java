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
import com.cib.user.util.JwtUtil;
import jakarta.servlet.http.HttpSession;

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

    @Autowired
    private JwtUtil jwtUtil;

    private static final String AUTH_SERVICE_URL = "http://localhost:8081/api/auth";

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestHeader("Authorization") String token,
                                              @RequestBody CustomerDto customerDto) {
       String accessToken=token.replace("Bearer", "");
       if(!jwtUtil.validateToken(accessToken)){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Or Expired Token");
       }

       String userNameFromToken = jwtUtil.extractUsername(accessToken);
       
       if(!userNameFromToken.equalsIgnoreCase(customerDto.getUserName())){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UserName mismatch: Token and Payload Do not match");
       }

       Customer customer=userMapper.toEntity((customerDto));
       return ResponseEntity.ok(userMapper.toDto(userService.registerCustomer(customer)));
    
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
    public ResponseEntity<?> login(@RequestBody Map<String,String> credentials, HttpSession session) {
            ResponseEntity<Map> response= restTemplate.postForEntity(AUTH_SERVICE_URL+"/login",credentials , Map.class);
            if(response.getStatusCode()==HttpStatus.OK && response.getBody()!=null){
                session.setAttribute("accessToken", response.getBody().get("accessToken"));
                session.setAttribute("expiresIn", response.getBody().get("expiresIn"));
            }
            return response;
    }

    // POST: Logout
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
            String token = (String) session.getAttribute("accessToken");
            if(token==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Token Stored for logout");
            }
            Map<String,String> body=new HashMap<>();
            body.put("token", token);
            ResponseEntity<String> response = restTemplate.postForEntity(AUTH_SERVICE_URL+"/logout", body, String.class);
            session.invalidate();
            return response;
        }

}