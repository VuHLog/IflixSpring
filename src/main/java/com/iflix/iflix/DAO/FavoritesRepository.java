package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, String> {

    @Query(value = "select * from favorites as f where f.user_id= :userId",nativeQuery = true)
    List<Favorites> findByUserId(String userId);

    @Query(value = "select * from favorites as f where f.user_id= :userId and f.movie_id = :movieId",nativeQuery = true)
    Favorites findByUserIdAndMovieId(String userId,String movieId);

    @Modifying
    @Query(value = "DELETE f from favorites as f where f.user_id = :userId and f.movie_id= :movieId",nativeQuery = true)
    void deleteByUserIdAndMovieId(String userId,String movieId);
}