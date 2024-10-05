package com.bank.repositories;

import com.bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
    User findByName(String name);


}
