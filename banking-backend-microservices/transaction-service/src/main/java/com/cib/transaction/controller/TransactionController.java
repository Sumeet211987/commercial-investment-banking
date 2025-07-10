package com.cib.transaction.controller;

import java.util.Optional;

import com.cib.transaction.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cib.transaction.model.TransactionRequest;
import com.cib.transaction.model.TransactionResponse;
import com.cib.transaction.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private  TransactionService service;
	
//	public TransactionController(TransactionService service) {
//		this.service = service;
//	}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody TransactionRequest request) {
		return ResponseEntity.ok(service.createTransaction(request));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Optional<Transaction>> getUserTranaction(@PathVariable Long userId) {
		System.out.println("Controller " + userId);
		return ResponseEntity.ok(service.getUserTransactions(userId));
	}
	
	
}
