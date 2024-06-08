package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Movie_Actor;
import com.iflix.iflix.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepository extends JpaRepository<Movie_Actor, String> {
    Movie_Actor findByMovie_IdAndActor_Id(String id, String id1);

    @Modifying
    @Query("DELETE FROM Movie_Actor ur WHERE ur.movie = :movie")
    void deleteByMovie(Movies movie);

    @Modifying
    @Query(value = "DELETE mt from movie_actor as mt where mt.movie_id = :movieId",nativeQuery = true)
    void deleteByMovieId(String movieId);
}
