package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
}