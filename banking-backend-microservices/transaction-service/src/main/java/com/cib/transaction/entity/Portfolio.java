package com.cib.transaction.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cib.transaction.utility.PortfolioStatus;
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
@Table (name = "portfolio") 
public class Portfolio {
  

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Long id; 
	
	@Column(name="portfolionumber",length = 100, nullable = false, unique = true)
	public String portfolioNumber; 
	
	@Column(name="portfoliotype",length = 50, nullable = false)
	public String portfolioType; 
	
	@Enumerated(EnumType.STRING) 
	@Column(length = 50, nullable = false) 
	public PortfolioStatus status; 
	
	@ManyToOne 	
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	public User user; 
	
	@Column(nullable = false) 
	public LocalDate startdate;
	
	@Column
	public LocalDateTime updateddate = LocalDateTime.now();

	@Column
	public LocalDate enddate;

} 