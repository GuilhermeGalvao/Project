package com.example.projectspendingcontrol.repository;

import com.example.projectspendingcontrol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    List<User> findAll();
    Optional<User> findByEmail(String email);

}
