package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Countries;
import com.iflix.iflix.Entities.Genres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    boolean existsByName(String name);

    Countries findByName(String name);

    Page<Countries> findByNameContainsIgnoreCase(String name, Pageable pageable);
}