package com.example.barbershop.repository;

import com.example.barbershop.models.EmailForm;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

public interface EmailRepository extends CrudRepository<EmailForm, BigInteger> {
    @Modifying
    @Query(value = "insert into emails (email) values (:email) on conflict (email) do nothing", nativeQuery = true)
    @Transactional
    void saveEmail(@Param("email") String email);
}
