package com.cib.transaction.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

	public Long portfolioId;
	public String transactiontype;
	public String referenceId;
	public LocalDate startDate;
	public LocalDate endDate;
	public String comments;
}
