package com.vti.be.repository;


import com.vti.be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
