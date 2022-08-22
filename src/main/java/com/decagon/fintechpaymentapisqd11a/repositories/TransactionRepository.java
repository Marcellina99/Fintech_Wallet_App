package com.decagon.fintechpaymentapisqd11a.repositories;

import com.decagon.fintechpaymentapisqd11a.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
