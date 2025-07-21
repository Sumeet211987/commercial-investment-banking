package com.cib.transaction.service;

import com.cib.transaction.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionQuery implements com.cib.transaction.repository.TransactionRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transaction> findByPortfolioUserId(Long userId) {
        System.out.println("findby" + userId);
        String query = "SELECT t FROM Transaction t WHERE t.portfolio.user.id = :userId";
        TypedQuery<Transaction> typedQuery = entityManager.createQuery(query,Transaction.class);
        System.out.println("Query" + userId);
        typedQuery.setParameter("userId",userId);
        System.out.println("Query1" + typedQuery.getResultList().size());
        return typedQuery.getResultList();
    }
}
