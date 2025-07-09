package com.cib.compliance.service;

import com.cib.compliance.entity.AuditLog;
import com.cib.compliance.entity.Compliance;

import java.util.List;

public interface ComplianceService {
	Compliance submitKYC(Compliance compliance);

	AuditLog getAuditTrail(Long userId);

	Compliance getKyc(Long id);

    List<Compliance> getAllCompliance();

	//Compliance updateCompliance(Long id, Compliance updatedCompliance);

	//void deleteCompliance(Long id);
}