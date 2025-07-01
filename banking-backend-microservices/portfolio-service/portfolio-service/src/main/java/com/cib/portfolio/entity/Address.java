package com.cib.portfolio.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, nullable = false)
	private String address1;
	
	@Column(length = 255, nullable = false)
	private String address2;
	
	@Column(length = 100, nullable = false)
	private String city;
	
	@Column(length = 100, nullable = false)
	private String state;
	
	@Column(length = 20, nullable = false)
	private String pincode;
	
	@Column(length = 100, nullable = false)
	private String country;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column
	private LocalDateTime updatedDate = LocalDateTime.now();
	
	@Column
	private LocalDate endDate;
	
	
}
