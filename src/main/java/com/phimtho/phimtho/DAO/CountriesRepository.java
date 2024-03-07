package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, Integer> {
}