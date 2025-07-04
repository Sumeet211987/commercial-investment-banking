package com.cib.transaction.repository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByPortfolioUserId(Long userId);
}
