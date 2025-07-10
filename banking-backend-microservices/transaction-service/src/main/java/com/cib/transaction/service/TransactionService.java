package com.cib.transaction.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cib.transaction.entity.Portfolio;
import com.cib.transaction.entity.Transaction;
import com.cib.transaction.model.TransactionRequest;
import com.cib.transaction.model.TransactionResponse;
import com.cib.transaction.repository.PortfolioRepository;
import com.cib.transaction.repository.TransactionRepository;
import com.cib.transaction.utility.MockPaymentGateway;
import com.cib.transaction.utility.TransactionStatus;

@Service
public class TransactionService {

	@Autowired
    private  TransactionRepository repository;

	@Autowired
    private  PortfolioRepository portfolioRepository;
	@Autowired
    private  MockPaymentGateway paymentGateway;

	@Autowired
	private TransactionQuery transactionQuery;
    
//    public TransactionService(TransactionRepository repository, PortfolioRepository portfolioRepository, MockPaymentGateway paymentGateway) {
//    	this.repository = repository;
//    	this.portfolioRepository = portfolioRepository;
//    	this.paymentGateway = paymentGateway;
//    }
    
    public TransactionResponse createTransaction(TransactionRequest request) {
    	Portfolio portfolio = portfolioRepository.findById(request.portfolioId)
    			.orElseThrow(() -> new RuntimeException("Portfolio not found"));
    	Transaction txn = new Transaction();
    	txn.setPortfolio(portfolio);
    	txn.setReferenceId(request.referenceId);
    	txn.setTransactionType(request.getTransactiontype());
    	txn.setStartDate(request.getStartDate());
    	txn.setEndDate(request.getEndDate());
    	txn.setComments(request.getComments());
    	txn.setStatus(TransactionStatus.PENDING);
    	txn.setTransactionDate(LocalDate.now());
    	
    	boolean paymentSuccess = paymentGateway.processPayment(request.referenceId, 100.0); //static amount for poc
    	txn.setStatus(paymentSuccess ? TransactionStatus.COMPLETED : TransactionStatus.FAILED);
    	repository.save(txn);
    	
    	TransactionResponse response = new TransactionResponse();
    	response.id = txn.getId();
    	response.referenceId = txn.getReferenceId();
    	response.transactiontype = txn.getTransactionType();
    	response.status = txn.getStatus();
    	response.transactionDate = txn.getTransactionDate();
    	response.comments = txn.getComments();
    	return response;
    }
    
    public Optional<Transaction> getUserTransactions(Long userId) {
		System.out.println("gettransaction " + userId);
		Optional<Transaction> transaction = repository.findById(userId);
		if(transaction.isPresent()){

			Transaction transaction1 = transaction.get();
			System.out.println("userTransactiontype" +transaction1.getTransactionType());
		}
		else
		{
			System.out.println("type is  null");
		}
		return repository.findById(userId);


//    	return transactionQuery.findByPortfolioUserId (userId).stream().map(txn -> {
//    		TransactionResponse res = new TransactionResponse();
//    		res.id = txn.getId();
//    		res.referenceId = txn.getReferenceId();
//    		res.transactiontype = txn.getTransactionType();
//    		res.status = txn.getStatus();
//    		res.transactionDate = txn.getTransactionDate();
//    		res.comments = txn.getComments();
//    		return res;
//    	}).collect(Collectors.toList());
    	
    }
    
    
}
