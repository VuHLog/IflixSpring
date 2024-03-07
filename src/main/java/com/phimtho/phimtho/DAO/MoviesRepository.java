package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
}