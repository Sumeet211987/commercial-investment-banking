package com.cib.compliance.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audit log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(nullable = false)
	public LocalDateTime timestamp;

	@Column(columnDefinition = "TEXT", nullable = false)
	public String message;

	@Column(length = 100, nullable = false)
	public String action;

	@Column(length = 50, nullable = false)
	public String status;

	@Column(length = 45)
	public String ipAddress;

	@Column(nullable = false)
	public LocalDate startDate;

	@Column
	public LocalDateTime updatedDate = LocalDateTime.now();

	@Column
	public LocalDate endDate;

//	public AuditLog() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public AuditLog(Long id, LocalDateTime timestamp, String message, String action, String status, String ipAddress,
//			LocalDate startDate, LocalDateTime updatedDate, LocalDate endDate) {
//		super();
//		this.id = id;
//		this.timestamp = timestamp;
//		this.message = message;
//		this.action = action;
//		this.status = status;
//		this.ipAddress = ipAddress;
//		this.startDate = startDate;
//		this.updatedDate = updatedDate;
//		this.endDate = endDate;
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
//	public LocalDateTime getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(LocalDateTime timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getAction() {
//		return action;
//	}
//
//	public void setAction(String action) {
//		this.action = action;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getIpAddress() {
//		return ipAddress;
//	}
//
//	public void setIpAddress(String ipAddress) {
//		this.ipAddress = ipAddress;
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
//	public LocalDateTime getUpdatedDate() {
//		return updatedDate;
//	}
//
//	public void setUpdatedDate(LocalDateTime updatedDate) {
//		this.updatedDate = updatedDate;
//	}
//
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}

}
