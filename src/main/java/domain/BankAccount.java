package domain;

import jakarta.persistence.*;
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long bankAccount;
    private String userName;
}
