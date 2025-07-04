package com.cib.transaction.model;

import java.time.LocalDate;

import com.cib.transaction.utility.TransactionStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponse {

	public Long id;
	public String referenceId;
	public String transactiontype;
	public TransactionStatus status;
	public LocalDate transactionDate;
	public String comments;
}
