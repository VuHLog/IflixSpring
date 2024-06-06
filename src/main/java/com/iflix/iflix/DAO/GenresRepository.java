package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Genres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genres, String> {

    boolean existsByName(String name);

    Genres findByName(String name);

    Page<Genres> findByNameContainsIgnoreCase(String name, Pageable pageable);
}