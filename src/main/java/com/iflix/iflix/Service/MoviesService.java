package com.iflix.iflix.Service;

import com.iflix.iflix.Entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MoviesService {
    public Movies getById(String id);
    public Movies addMovie(Movies movie);

    public Movies updateMovie(Movies movie);

    public void deleteMovie(Movies movie);

    public Page<Movies> findMovies(Pageable pageable);
}
