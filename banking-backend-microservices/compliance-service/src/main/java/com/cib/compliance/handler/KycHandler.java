//package com.cib.compliance.handler;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.cib.compliance.entity.KycDocument;
//import com.cib.compliance.service.ComplianceService;
//
//@Component
////@RequiredArgsConstructor
//public class KycHandler {
//	
//	@Autowired
//	ComplianceService complianceService;
//
//	public KycDocument handleKycSubmission(KycDocument kycDocument) {
//		// You can add custom validations or formatting logic here
//		return complianceService.submitKyc(kycDocument);
//	}
//
//	public List<KycDocument> handleGetUserKyc(String userId) {
//		return complianceService.getUserKycDocuments(userId);
//	}
//
//	public void handleDeleteKyc(Long id) {
//		complianceService.deleteKyc(id);
//	}
//
//	public KycDocument handleUpdateKyc(Long id, KycDocument newData) {
//		return complianceService.updateKyc(id, newData);
//	}
//
//}
