package com.cib.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cib.compliance.entity.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Long> {

}
