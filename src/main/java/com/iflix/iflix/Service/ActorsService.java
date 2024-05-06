package com.iflix.iflix.Service;

import com.iflix.iflix.Entities.Actors;

public interface ActorsService {
    public Actors findById(String id);
    public Actors addActor(Actors actor);

    public Actors updateActor(Actors actor);

    public void deleteBook(Actors actor);
}
