package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, String> {
}