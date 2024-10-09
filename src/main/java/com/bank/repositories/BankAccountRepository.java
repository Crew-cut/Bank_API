package com.bank.repositories;

import com.bank.domain.BankAccount;
import com.bank.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query("select b from BankAccount b")
    @Override
    List<BankAccount> findAll();

    @Query("select b from BankAccount b where upper(b.userId) = upper(?1)")
    List<BankAccount> findByUserIdIgnoreCase(Long userId);

    @Query("select b from BankAccount b where b.userId = ?1")
    List<BankAccount> findByUserId(Long userId);
    @Query ("select b from BankAccount b where b.userId = ?1")
    BankAccount findFirstByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update BankAccount b set b.balance = ?1")
    int updateBalanceBy(long balance);

}