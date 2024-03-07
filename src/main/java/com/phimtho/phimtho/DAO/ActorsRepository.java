package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Actors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorsRepository extends JpaRepository<Actors, Integer> {
}