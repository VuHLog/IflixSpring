package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Movie_Genre;
import com.iflix.iflix.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreRepository extends JpaRepository<Movie_Genre, String> {
    Movie_Genre findByMovie_IdAndGenre_Id(String id, String id1);

    @Modifying
    @Query("DELETE FROM Movie_Genre ur WHERE ur.movie = :movie")
    void deleteByMovie(Movies movie);


}
