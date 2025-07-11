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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "referenceid", length = 100, nullable = false)
	private String referenceId;
	
	@ManyToOne
	@JoinColumn(name = "portfolioid", nullable = false)
	private Portfolio portfolio;
	
	@Column(name = "transactiontype", length = 50 , nullable = false)
	private String transactionType;
	
	@Column(name = "transactiondate", nullable = false)
	private LocalDate transactionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 50, nullable = false)
	public TransactionStatus status;
	
	@Column(name = "comments", columnDefinition = "Text")
	private String comments;
	
	@Column(name = "startdate", nullable = false)
	private LocalDate startDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate = LocalDateTime.now();

	@Column(name = "enddate", nullable = true)
	private LocalDate endDate;

}

