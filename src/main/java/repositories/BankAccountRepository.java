package repositories;

import domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Override
    List<BankAccount> findAll();

    @Query("select b from BankAccount b where upper(b.userName) = upper(?1)")
    List<BankAccount> findByUserNameIgnoreCase(String userName);

    @Query("select b from BankAccount b where b.userName = ?1")
    List<BankAccount> findByUserName(String userName);
}