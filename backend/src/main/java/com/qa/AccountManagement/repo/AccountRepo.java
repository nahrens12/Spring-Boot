package com.qa.AccountManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.AccountManagement.model.Accounts;

public interface AccountRepo extends JpaRepository<Accounts, Long> {

}
