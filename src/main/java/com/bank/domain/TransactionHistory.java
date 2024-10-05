package com.bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String history;
    private String userName;

    public TransactionHistory() {
    }

    public long getId() {
        return id;
    }

    public TransactionHistory setId(long id) {
        this.id = id;
        return this;
    }

    public String getHistory() {
        return history;
    }

    public TransactionHistory setHistory(String history) {
        this.history = history;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TransactionHistory setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistory that = (TransactionHistory) o;
        return id == that.id && Objects.equals(history, that.history) && Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, history, userName);
    }
}
