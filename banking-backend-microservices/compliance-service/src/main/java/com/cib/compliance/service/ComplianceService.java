package com.cib.compliance.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cib.compliance.entity.AuditLog;
import com.cib.compliance.entity.KycDocument;
import com.cib.compliance.repository.AuditLogRepository;
import com.cib.compliance.repository.KycDocumentRepository;

@Service
public class ComplianceService {

    private final KycDocumentRepository kycRepo;
    private final AuditLogRepository auditRepo;

    public ComplianceService(KycDocumentRepository kycRepo, AuditLogRepository auditRepo) {
        this.kycRepo = kycRepo;
        this.auditRepo = auditRepo;
    }

    public KycDocument submitKyc(KycDocument request) {
        request.setSubmittedAt(LocalDateTime.now());
        request.setStatus("VERIFIED");
        request.setRemarks("Auto verified by system");

        KycDocument saved = kycRepo.save(request);

        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(saved.getUserId());
        auditLog.setAction("KYC_SUBMISSION");
        auditLog.setDetails("KYC submitted and marked as VERIFIED.");
        auditLog.setTimestamp(LocalDateTime.now());

        auditRepo.save(auditLog);

        return saved;
    }

    public List<AuditLog> getAuditTrail(String userId) {
        return auditRepo.findByUserIdOrderByTimestampDesc(userId);
    }

    public List<KycDocument> getUserKycDocuments(String userId) {
        return kycRepo.findByUserId(userId);
    }

    public void deleteKyc(Long id) {
        kycRepo.findById(id).ifPresent(doc -> {
            kycRepo.deleteById(id);

            AuditLog auditLog = new AuditLog();
            auditLog.setUserId(doc.getUserId());
            auditLog.setAction("KYC_DELETION");
            auditLog.setDetails("KYC document deleted with ID: " + id);
            auditLog.setTimestamp(LocalDateTime.now());

            auditRepo.save(auditLog);
        });
    }

    public KycDocument updateKyc(Long id, KycDocument updatedDoc) {
        return kycRepo.findById(id).map(existing -> {
            existing.setDocumentType(updatedDoc.getDocumentType());
            existing.setDocumentNumber(updatedDoc.getDocumentNumber());
            existing.setStatus("UPDATED");
            existing.setRemarks("Updated by user");
            return kycRepo.save(existing);
        }).orElseThrow(() -> new RuntimeException("KYC not found with ID: " + id));
    }
}
