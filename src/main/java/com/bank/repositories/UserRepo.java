package com.bank.repositories;

import com.bank.domain.Users;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository <Users, Long> {
    @Query("select u from Users u where upper(u.name) = upper(?1)")
    List<Users> findByNameIgnoreCase(String name);




}
