package com.cib.transaction.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cib.transaction.utility.TransactionStatus;

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
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String referenceId;
	
	@ManyToOne
	@JoinColumn(name = "portfolioId")
	private Portfolio Portfolio;
	
	@Column(length = 50 , nullable = false)
	private String transactionType;
	
	@Column(nullable = false)
	private LocalDate transactionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	public TransactionStatus status;
	
	@Column(columnDefinition = "Text")
	private String comments;
	
	@Column(nullable = false)
	private LocalDate startDate;

	@Column
	private LocalDateTime updateDate = LocalDateTime.now();

	@Column(nullable = false)
	private LocalDate endDate;

}

