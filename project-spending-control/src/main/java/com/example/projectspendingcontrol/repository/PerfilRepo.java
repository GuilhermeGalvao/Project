package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepo extends JpaRepository<Perfil, Long> {
    Perfil findByName(String name);
}
