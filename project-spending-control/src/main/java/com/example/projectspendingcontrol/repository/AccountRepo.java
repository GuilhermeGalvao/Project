package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.dto.AccountDto;
import com.example.projectspendingcontrol.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    List<AccountDto> findByUserId(String id);
}
