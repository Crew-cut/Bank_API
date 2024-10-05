package com.bank.repositories;

import com.bank.domain.TransactionHistory;

public interface TransactionHistoryRepository {

    TransactionHistory findByUserName (String userName);
}
