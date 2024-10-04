package repositories;

import domain.BankAccount;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    @Override
    List<BankAccount> findAll();

    @Query("select b from BankAccount b where upper(b.userName) = upper(?1)")
    List<BankAccount> findByUserNameIgnoreCase(String userName);

    @Query("select b from BankAccount b where b.userName = ?1")
    List<BankAccount> findByUserName(String userName);
}