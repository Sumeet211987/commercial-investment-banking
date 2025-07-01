package com.cib.compliance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cib.compliance.entity.AuditLog;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByUserIdOrderByTimestampDesc(String userId);
}

