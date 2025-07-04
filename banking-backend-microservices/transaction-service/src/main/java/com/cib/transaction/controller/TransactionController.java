package com.cib.transaction.controller;

import java.util.List;

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
	
	private final TransactionService service;
	
	public TransactionController(TransactionService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody TransactionRequest request) {
		return ResponseEntity.ok(service.createTransaction(request));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<TransactionResponse>> getUserTranaction(@PathVariable Long userId) {
		return ResponseEntity.ok(service.getUserTransactions(userId));
	}
	
	
}
