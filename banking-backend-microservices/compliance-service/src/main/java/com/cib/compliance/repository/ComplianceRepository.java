package com.cib.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cib.compliance.entity.Compliance;
@Repository
public interface ComplianceRepository extends JpaRepository<Compliance, Long> {
	List<Compliance> findByUserId(Long userId);
}