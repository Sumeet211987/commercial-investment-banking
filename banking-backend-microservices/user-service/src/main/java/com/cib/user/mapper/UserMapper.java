package com.cib.user.mapper;

import org.springframework.stereotype.Component;

import com.cib.user.dto.Customer;
import com.cib.user.dto.CustomerDto;

@Component
public class UserMapper {

    public CustomerDto toDto(Customer customer){
        return new CustomerDto(
            customer.getUserId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getUserName(),
            customer.getEmailId(),
            customer.getPhoneNumber(),
            customer.getIdentityNumber(),
            customer.getAddress(),
            customer.getPassword(),
            customer.isActive()
        );
    }

    public Customer toEntity(CustomerDto dto){

        Customer customer=new Customer();
        customer.setUserId(dto.getUserId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setUserName(dto.getUserName());
        customer.setEmailId(dto.getEmailId());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setIdentityNumber(dto.getIdentityNumber());
        customer.setAddress(dto.getAddress());
        customer.setPassword(dto.getPassword());
        customer.setActive(false);
        return customer;

    }

    public void updateEntityFromDto(CustomerDto dto, Customer customer){
        if (dto.getFirstName()!=null) customer.setFirstName(dto.getFirstName());
        if (dto.getLastName()!=null) customer.setLastName(dto.getLastName());
        if (dto.getEmailId()!= null) customer.setEmailId(dto.getEmailId());
        if (dto.getPhoneNumber()!=null) customer.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getIdentityNumber()!=null) customer.setIdentityNumber(dto.getIdentityNumber());
        if (dto.getAddress()!= null) customer.setAddress(dto.getAddress());
        if (dto.getPassword() != null) customer.setPassword(dto.getPassword());
    }

}
