package com.cib.transaction.utility;

import org.springframework.stereotype.Component;

@Component
public class MockPaymentGateway {

	public boolean processPayment(String referenceId, double amount) {
		return Math.random() > 0.1;  //90% chance of success
	}
}
