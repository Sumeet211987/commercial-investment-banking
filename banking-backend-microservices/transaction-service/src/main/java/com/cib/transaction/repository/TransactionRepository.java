package com.cib.transaction.repository;

import com.cib.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//   Optional<Transaction> findById (Long userId);

//    @Query("SELECT + FROM Transaction + WHERE t. portfolio user.id = userId")
//    List<Transaction> findByUserId(@Param("userId") Long userId);
}
