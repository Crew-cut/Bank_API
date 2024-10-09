package com.bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String history;
    private Long recipientId;
    private Long senderId;

    public TransactionHistory() {
    }

    public TransactionHistory(String history, Long recipientId) {
        this.history = history;
        this.recipientId = recipientId;
    }

    public TransactionHistory(String history, Long recipientId, Long senderId) {
        this.history = history;
        this.recipientId = recipientId;
        this.senderId = senderId;
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

    public Long getRecipientId() {
        return recipientId;
    }

    public TransactionHistory setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
        return this;
    }
    public Long getSenderId() {
        return senderId;
    }
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHistory that = (TransactionHistory) o;
        return id == that.id && Objects.equals(history, that.history) && Objects.equals(recipientId, that.recipientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, history, recipientId);
    }
}
