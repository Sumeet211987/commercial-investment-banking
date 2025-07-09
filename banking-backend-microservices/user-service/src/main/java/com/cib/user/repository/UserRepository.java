package com.cib.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cib.user.dto.Customer;

public interface UserRepository extends JpaRepository<Customer,Long> {
    
} 