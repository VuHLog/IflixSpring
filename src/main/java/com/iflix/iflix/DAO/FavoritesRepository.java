package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, String> {
}