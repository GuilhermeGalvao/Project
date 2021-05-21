package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payments, Long> {
    List<Payments> findByAccountIdAndDateBetween(Long id, LocalDate dateInit, LocalDate dateFinal);
}
