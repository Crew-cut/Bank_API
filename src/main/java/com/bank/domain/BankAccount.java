package com.bank.domain;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bankAccount;


    private int pinCode;
    private long balance;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users userId;

    public BankAccount() {
    }

    public BankAccount(Users userId, Integer pinCode) {
        this.userId = userId;
        this.pinCode = pinCode;
        this.balance = 0;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public long getBalance() {
        return balance;
    }

    public BankAccount setBalance(long balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return bankAccount == that.bankAccount && userId == that.userId && pinCode == that.pinCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, userId);
    }
}
