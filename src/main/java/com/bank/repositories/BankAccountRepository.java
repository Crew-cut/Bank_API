package com.bank.repositories;

import com.bank.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query("select b from BankAccount b")
    @Override
    List<BankAccount> findAll();

    @Query("select b from BankAccount b where upper(b.userId) = upper(?1)")
    List<BankAccount> findByUserIdIgnoreCase(String userName);

    @Query("select b from BankAccount b where b.userId = ?1")
    List<BankAccount> findByUserId(String userName);
}