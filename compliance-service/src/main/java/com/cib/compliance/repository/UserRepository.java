package com.cib.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cib.compliance.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByEmailId(String emailId);
}
