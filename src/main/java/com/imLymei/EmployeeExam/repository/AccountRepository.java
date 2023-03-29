package com.imLymei.EmployeeExam.repository;

import com.imLymei.EmployeeExam.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAccountByUsernameIs(String username);
    Account findAccountByUsername(String username);
}
