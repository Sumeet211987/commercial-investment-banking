package com.cib.compliance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cib.compliance.entity.KycDocument;

public interface KycDocumentRepository extends JpaRepository<KycDocument, Long> {
    List<KycDocument> findByUserId(String userId);
}
