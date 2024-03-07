package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Integer> {
}