package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Integer> {
}