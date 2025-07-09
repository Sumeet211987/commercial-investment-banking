package com.cib.compliance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cib.compliance.entity.AuditLog;
import com.cib.compliance.entity.Compliance;
import com.cib.compliance.service.ComplianceService;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {
	@Autowired
	private ComplianceService complianceService;

	@GetMapping
	public List<Compliance> getAllCompliance(){
		return complianceService.getAllCompliance();
	}

//	@PutMapping("/kyc/{id}")
//	public ResponseEntity<Compliance> updateCompliance(
//			@PathVariable Long id,
//			@RequestBody Compliance updatedCompliance) {
//		Compliance compliance = complianceService.updateCompliance(id, updatedCompliance);
//		return ResponseEntity.ok(compliance);
//	}

	@PostMapping("/kyc")
	public ResponseEntity<Compliance> submitKYC(@RequestBody Compliance compliance) {
		return ResponseEntity.ok(complianceService.submitKYC(compliance));
	}

	@GetMapping("/kyc/{id}")
	public ResponseEntity<Compliance> getKyc(@PathVariable Long id) {
		return new ResponseEntity<Compliance>(complianceService.getKyc(id), HttpStatus.ACCEPTED);
	}

	@GetMapping("/audit/{userId}")
	public ResponseEntity<AuditLog> getAuditTrail(@PathVariable Long userId) {
		return ResponseEntity.ok(complianceService.getAuditTrail(userId));
	}

//	@DeleteMapping("/kyc/{id}")
//	public ResponseEntity<String> deleteCompliance(@PathVariable Long id) {
//		complianceService.deleteCompliance(id);
//		return ResponseEntity.ok("Compliance record deleted with ID: " + id);
//	}
}