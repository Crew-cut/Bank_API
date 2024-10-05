package com.bank.repositories;

import com.bank.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {

    TransactionHistory findByUserName (String userName);
}
