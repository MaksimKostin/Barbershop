package com.example.barbershop.repository;

import com.example.barbershop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    Boolean existsByUsername(String username);
}
