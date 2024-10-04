package domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long bankAccount;
    @ManyToOne
    @JoinColumn(name = "name")
    private String userName;

    private int pinCode;
    private long balance;

    public BankAccount() {
    }

    public BankAccount(String userName, Integer pinCode) {
        this.userName = userName;
        this.pinCode = pinCode;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return bankAccount == that.bankAccount && userName.equals(that.userName) && pinCode == that.pinCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, userName);
    }
}
