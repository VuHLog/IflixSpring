package com.phimtho.phimtho.Service;

import com.phimtho.phimtho.Entities.Actors;
import com.phimtho.phimtho.Entities.Movies;

public interface MoviesService {
    public Movies findById(int id);
    public Movies addActor(Movies movie);

    public Movies updateActor(Movies movie);

    public void deleteBook(Movies movie);
}
