package com.cib.compliance.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cib.compliance.enums.PortfolioStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(length = 100, nullable = false, unique = true)
	public String portfolioNumber;

	@Column(length = 50, nullable = false)
	public String portfolioType;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	public PortfolioStatus status;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	public User user;

	@Column(nullable = false)
	public LocalDate startDate;

	@Column
	public LocalDateTime updatedDate = LocalDateTime.now();

	@Column
	public LocalDate endDate;

	public Portfolio() {
		// TODO Auto-generated constructor stub
	}

	public Portfolio(Long id, String portfolioNumber, String portfolioType, PortfolioStatus status, User user,
			LocalDate startDate, LocalDateTime updatedDate, LocalDate endDate) {
		super();
		this.id = id;
		this.portfolioNumber = portfolioNumber;
		this.portfolioType = portfolioType;
		this.status = status;
		this.user = user;
		this.startDate = startDate;
		this.updatedDate = updatedDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPortfolioNumber() {
		return portfolioNumber;
	}

	public void setPortfolioNumber(String portfolioNumber) {
		this.portfolioNumber = portfolioNumber;
	}

	public String getPortfolioType() {
		return portfolioType;
	}

	public void setPortfolioType(String portfolioType) {
		this.portfolioType = portfolioType;
	}

	public PortfolioStatus getStatus() {
		return status;
	}

	public void setStatus(PortfolioStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
