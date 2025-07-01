package com.cib.compliance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cib.compliance.entity.AuditLog;
import com.cib.compliance.entity.KycDocument;
import com.cib.compliance.service.ComplianceService;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {
	@Autowired
	ComplianceService service;
	// KycHandler kycHandler;

	@PostMapping("/kyc")
	public ResponseEntity<KycDocument> submitKyc(@RequestBody KycDocument kycRequest) {
		KycDocument result = service.submitKyc(kycRequest);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/audit/{userId}")
	public ResponseEntity<List<AuditLog>> getAudit1(@PathVariable String userId) {
		return ResponseEntity.ok(service.getAuditTrail(userId));
	}

//	@PostMapping("/kyc")
//	public ResponseEntity<KycDocument> submitKyc1(@RequestBody KycDocument kycRequest) {
//		return ResponseEntity.ok(kycHandler.handleKycSubmission(kycRequest));
//	}
//
//	@GetMapping("/audit/{userId}")
//	public ResponseEntity<List<AuditLog>> getAudit(@PathVariable String userId) {
//		return ResponseEntity.ok(service.getAuditTrail(userId));
//	}
//
//	@GetMapping("/kyc/{userId}")
//	public ResponseEntity<List<KycDocument>> getKycForUser(@PathVariable String userId) {
//		return ResponseEntity.ok(kycHandler.handleGetUserKyc(userId));
//	}
//
//	@DeleteMapping("/kyc/{id}")
//	public ResponseEntity<Void> deleteKyc(@PathVariable Long id) {
//		kycHandler.handleDeleteKyc(id);
//		return ResponseEntity.noContent().build();
//	}
//
//	@PutMapping("/kyc/{id}")
//	public ResponseEntity<KycDocument> updateKyc(@PathVariable Long id, @RequestBody KycDocument doc) {
//		return ResponseEntity.ok(kycHandler.handleUpdateKyc(id, doc));
//	}
}