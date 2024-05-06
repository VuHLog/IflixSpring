package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, String> {
}