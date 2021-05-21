package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card, Long > {
}
