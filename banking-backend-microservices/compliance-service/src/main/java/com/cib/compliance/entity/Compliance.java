package com.cib.compliance.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cib.compliance.enums.ComplianceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compliance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compliance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false, length = 100)
	private String identityType;

	@Column(nullable = false, length = 100)
	private String identityNumber;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String documentUrl;

	@Column(nullable = false, length = 100)
	private String documentType;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private ComplianceStatus status;

	@Column(nullable = false)
	private LocalDate submissionDate;

	private LocalDate verifiedDate;

	@Column(length = 100)
	private String verifiedBy;

	@Column(columnDefinition = "TEXT")
	private String remarks;

	@Column(nullable = false)
	private LocalDate startDate;

	private LocalDate endDate;

	private LocalDateTime updatedDate = LocalDateTime.now();

//	public Compliance() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Compliance(Long id, User user, String identityType, String identityNumber, String documentUrl,
//			String documentType, ComplianceStatus status, LocalDate submissionDate, LocalDate verifiedDate,
//			String verifiedBy, String remarks, LocalDate startDate, LocalDate endDate, LocalDateTime updatedDate) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.identityType = identityType;
//		this.identityNumber = identityNumber;
//		this.documentUrl = documentUrl;
//		this.documentType = documentType;
//		this.status = status;
//		this.submissionDate = submissionDate;
//		this.verifiedDate = verifiedDate;
//		this.verifiedBy = verifiedBy;
//		this.remarks = remarks;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.updatedDate = updatedDate;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public String getIdentityType() {
//		return identityType;
//	}
//
//	public void setIdentityType(String identityType) {
//		this.identityType = identityType;
//	}
//
//	public String getIdentityNumber() {
//		return identityNumber;
//	}
//
//	public void setIdentityNumber(String identityNumber) {
//		this.identityNumber = identityNumber;
//	}
//
//	public String getDocumentUrl() {
//		return documentUrl;
//	}
//
//	public void setDocumentUrl(String documentUrl) {
//		this.documentUrl = documentUrl;
//	}
//
//	public String getDocumentType() {
//		return documentType;
//	}
//
//	public void setDocumentType(String documentType) {
//		this.documentType = documentType;
//	}
//
//	public ComplianceStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(ComplianceStatus status) {
//		this.status = status;
//	}
//
//	public LocalDate getSubmissionDate() {
//		return submissionDate;
//	}
//
//	public void setSubmissionDate(LocalDate submissionDate) {
//		this.submissionDate = submissionDate;
//	}
//
//	public LocalDate getVerifiedDate() {
//		return verifiedDate;
//	}
//
//	public void setVerifiedDate(LocalDate verifiedDate) {
//		this.verifiedDate = verifiedDate;
//	}
//
//	public String getVerifiedBy() {
//		return verifiedBy;
//	}
//
//	public void setVerifiedBy(String verifiedBy) {
//		this.verifiedBy = verifiedBy;
//	}
//
//	public String getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//
//	public LocalDate getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(LocalDate startDate) {
//		this.startDate = startDate;
//	}
//
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}
//
//	public LocalDateTime getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(LocalDateTime updatedDate) {
//		this.updatedDate = updatedDate;
//	}

}