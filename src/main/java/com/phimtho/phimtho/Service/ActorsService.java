package com.phimtho.phimtho.Service;

import com.phimtho.phimtho.Entities.Actors;

public interface ActorsService {
    public Actors findById(int id);
    public Actors addActor(Actors actor);

    public Actors updateActor(Actors actor);

    public void deleteBook(Actors actor);
}
