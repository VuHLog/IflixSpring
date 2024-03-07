package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
}