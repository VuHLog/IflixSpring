package com.phimtho.phimtho.Service;

import com.phimtho.phimtho.Entities.Actors;
import com.phimtho.phimtho.Entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface MoviesService {
    public Movies findById(int id);
    public Movies addActor(Movies movie);

    public Movies updateActor(Movies movie);

    public void deleteBook(Movies movie);

    public Page<Movies> findMovies(Pageable pageable);
}
