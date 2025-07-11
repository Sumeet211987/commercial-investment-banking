package com.cib.transaction.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "address1", length = 255, nullable = false)
	private String address1;

	@Column(name = "address2", length = 255, nullable = false)
	private String address2;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "state", length = 100, nullable = false)
	private String state;

	@Column(name = "pincode", length = 20, nullable = false)
	private String pincode;

	@Column(name = "country" , length = 100, nullable = false)
	private String country;

	@Column(name = "startdate", nullable = false)
	private LocalDate startdate;

	@Column(name = "updateddate" )
	private LocalDateTime updateddate = LocalDateTime.now();

	@Column(name = "enddate")
	private LocalDate enddate;

}