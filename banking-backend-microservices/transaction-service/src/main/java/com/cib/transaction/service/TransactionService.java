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
    
    public String createTransaction(TransactionRequest request) {
		Optional<Portfolio> portfolio = portfolioRepository.findById(request.portfolioId);

		Portfolio entity = null;

		if (portfolio.isPresent()) {

			 entity = portfolio.get();


			Transaction txn = new Transaction();
			txn.setPortfolio(entity);
			txn.setReferenceId(request.referenceId);
			System.out.println("trnasaction type"+request.getTransactionType());
			txn.setTransactionType(request.getTransactionType());
			txn.setStartDate(request.getStartDate());
			txn.setEndDate(request.getEndDate());
			txn.setComments(request.getComments());
			txn.setStatus(TransactionStatus.PENDING);
			txn.setTransactionDate(LocalDate.now());

			boolean paymentSuccess = paymentGateway.processPayment(request.referenceId, 100.0); //static amount for poc
			txn.setStatus(paymentSuccess ? TransactionStatus.COMPLETED : TransactionStatus.FAILED);
			repository.save(txn);

			TransactionResponse response = new TransactionResponse();
			response.setId(txn.getId());
			response.setReferenceId( txn.getReferenceId());
			response.setTransactiontype(txn.getTransactionType());
			response.setStatus(txn.getStatus());
			response.setTransactionDate(txn.getTransactionDate());
			response.setComments(txn.getComments());

			return TransactionStatus.COMPLETED.toString();
		}
		else

		{
			System.out.println("Portfolio not found");
			return TransactionStatus.FAILED.toString();

		}


    }
    
    public Transaction getUserTransactions(Long userId) {
		System.out.println("gettransaction " + userId);
		Optional<Transaction> transaction = repository.findById(userId);
		Transaction transaction1 = null;
		if(transaction.isPresent()){

			 transaction1 = transaction.get();
			System.out.println("userTransactiontype" +transaction1.getTransactionType());
			return transaction1;
		}
		else
		{
			 return transaction1;
		}



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
