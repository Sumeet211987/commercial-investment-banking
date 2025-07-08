package com.cib.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cib.transaction.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	
	Optional<Portfolio> findById(Long userId);
    
}
