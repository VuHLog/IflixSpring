package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Genres;
import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movies, String> {
    boolean existsByName(String name);

    Optional<Movies> findByName(String name);

    Page<Movies> findByNameContainsIgnoreCase(String name, Pageable pageable);
}