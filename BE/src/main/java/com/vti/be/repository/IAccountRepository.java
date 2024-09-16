package com.vti.be.repository;

import com.vti.be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    Boolean existsByEmail(String email) ;

    Account findByEmail(String mail);
}