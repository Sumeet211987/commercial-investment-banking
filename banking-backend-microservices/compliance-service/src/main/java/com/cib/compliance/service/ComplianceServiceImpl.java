package com.cib.compliance.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cib.compliance.entity.AuditLog;
import com.cib.compliance.entity.Compliance;
import com.cib.compliance.entity.User;
import com.cib.compliance.enums.ComplianceStatus;
import com.cib.compliance.exception.ResourceNotFoundException;
import com.cib.compliance.repository.AuditRepository;
import com.cib.compliance.repository.ComplianceRepository;
import com.cib.compliance.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceServiceImpl implements ComplianceService {
	@Autowired
	private ComplianceRepository complianceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuditRepository auditRepository;

	@Override
	public Compliance submitKYC(Compliance compliance) {
		User user = userRepository.findById(compliance.getUser().getId()).orElseThrow(
				() -> new ResourceNotFoundException("User not found with ID " + compliance.getUser().getId()));

		compliance.setUser(user);
		compliance.setStatus(ComplianceStatus.PENDING);
		compliance.setUpdatedDate(LocalDateTime.now());

		return complianceRepository.save(compliance);
	}

	@Override
	public AuditLog getAuditTrail(Long id) {
		return auditRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Audit Not Found with id " + id));
	}

	@Override
	public Compliance getKyc(Long id) {
		return complianceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("kyc Not Found with id " + id));
	}

	@Override
	public List<Compliance> getAllCompliance() {
		return complianceRepository.findAll();
	}

//	@Override
//	public Compliance updateCompliance(Long id, Compliance updatedCompliance) {
//		Compliance existing = complianceRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Compliance not found with id " + id));
//
//		// Update all relevant fields
//		existing.setIdentityType(updatedCompliance.getIdentityType());
//		existing.setIdentityNumber(updatedCompliance.getIdentityNumber());
//		existing.setDocumentUrl(updatedCompliance.getDocumentUrl());
//		existing.setDocumentType(updatedCompliance.getDocumentType());
//		existing.setStatus(updatedCompliance.getStatus());
//		existing.setSubmissionDate(updatedCompliance.getSubmissionDate());
//		existing.setVerifiedDate(updatedCompliance.getVerifiedDate());
//		existing.setVerifiedBy(updatedCompliance.getVerifiedBy());
//		existing.setRemarks(updatedCompliance.getRemarks());
//		existing.setStartDate(updatedCompliance.getStartDate());
//		existing.setEndDate(updatedCompliance.getEndDate());
//		existing.setUpdatedDate(LocalDateTime.now());
//
//		return complianceRepository.save(existing);
//	}

//	@Override
//	public void deleteCompliance(Long id) {
//		Compliance compliance = complianceRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Compliance not found with id " + id));
//		complianceRepository.delete(compliance);
//	}

}