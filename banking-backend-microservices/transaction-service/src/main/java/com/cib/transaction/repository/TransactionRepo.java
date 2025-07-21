package com.cib.transaction.repository;

import com.cib.transaction.entity.Transaction;

import java.util.List;

public interface TransactionRepo  {

    List<Transaction> findByPortfolioUserId (Long userId);
}

