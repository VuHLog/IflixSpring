package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Actors;
import com.iflix.iflix.Entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorsRepository extends JpaRepository<Actors, String> {
    Actors findByName(String name);
}