package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
