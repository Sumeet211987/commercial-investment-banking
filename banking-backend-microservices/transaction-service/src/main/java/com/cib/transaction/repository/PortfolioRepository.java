package com.cib.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cib.transaction.entity.Portfolio;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	
//	Optional<Portfolio> findById(Long userId);
    
}
