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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@Column(name = "status", length = 50, nullable = false)
	public PortfolioStatus status; 
	
	@ManyToOne 	
	@JoinColumn(name = "userid", nullable = false)
	@JsonIgnore
	public User user;
	
	@Column(name = "startdate", nullable = false)
	public LocalDate startdate;
	
	@Column(name = "updateddate" )
	public LocalDateTime updateddate = LocalDateTime.now();

	@Column(name = "enddate")
	public LocalDate enddate;

} 