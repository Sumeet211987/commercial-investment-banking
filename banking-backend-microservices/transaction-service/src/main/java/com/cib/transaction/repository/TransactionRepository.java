package com.cib.transaction.repository;

import com.cib.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//	List<Transaction> findByPortfolioUserId (Long userId);
}
