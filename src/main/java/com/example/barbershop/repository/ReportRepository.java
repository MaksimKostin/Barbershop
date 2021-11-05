package com.example.barbershop.repository;

import com.example.barbershop.models.ReportForm;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ReportRepository extends CrudRepository<ReportForm, BigInteger> {
}
