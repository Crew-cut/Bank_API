package repositories;

import domain.TransactionHistory;

public interface TransactionHistoryRepository {

    TransactionHistory findByUserName (String userName);
}
