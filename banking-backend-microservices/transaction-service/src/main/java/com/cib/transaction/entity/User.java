package com.cib.transaction.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "users")
public class User {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, nullable = false,name="firstname")
	private String firstName;
	@Column(length = 100, nullable = false,name="lastname")
	private String lastName;
	@Column(name="emailid",length = 255, nullable = false, unique = true)
	private String emailId;
	@Column(name="phonenumber",length = 20)
	private String phoneNumber;
	@ManyToOne 
	@JoinColumn (name = "address_id") 
	private Address address;
	@Column(name="identitynumber",length = 50, unique = true)
	private String identityNumber;
	@Column(length = 50, nullable = false) 
	private String role;
	@ManyToOne 
	@JoinColumn (name = "portfolio_id") 
	private Portfolio Portfolio;
	@Column(nullable = false)
	private LocalDate startdate;
	@Column
	private LocalDateTime updateddate = LocalDateTime.now();
	@Column
	private LocalDate enddate;
}