package com.cib.user.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cib.user.dto.Customer;
import com.cib.user.dto.CustomerDto;
import com.cib.user.mapper.UserMapper;
import com.cib.user.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired UserMapper userMapper;

    public Customer registerCustomer(Customer customer) {
         customer.setActive(true);
         return userRepository.save(customer);
        

    }

    public Customer updateCustomer(Long id, CustomerDto customerDto){
        Customer customer = userRepository.findById(id).
        orElseThrow(()-> new RuntimeException("User not Found with Id: "+ id));
        userMapper.updateEntityFromDto(customerDto, customer);
        return userRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteCustomer(Long id){
        Customer customer=userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("User not Found with Id: "+id));
        customer.setActive(false);
        userRepository.save(customer);
    }

    // private boolean validateToken(Object object) {
    //  try{
    //     HttpHeaders headers= new HttpHeaders();
    //     headers.set("Authorization","Bearer "+ object);
    //     HttpEntity<String> entity=new HttpEntity<>(headers);
    //     ResponseEntity<String> response =restTemplate.exchange(AUTH_SERVICE_URL, HttpMethod.GET,entity,String.class);
    //     return response.getStatusCode().is2xxSuccessful();
    // } catch (Exception e) {
    //     return false;
    // }
        
    // }
    
}