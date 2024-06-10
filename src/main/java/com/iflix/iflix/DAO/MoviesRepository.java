package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Genres;
import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movies, String> {
    boolean existsByName(String name);

    Optional<Movies> findByName(String name);

    Page<Movies> findByNameContainsIgnoreCase(String name, Pageable pageable);

    @Query(value = "select top 5 * from movies as m order by num_view desc ",nativeQuery = true)
    List<Movies> findDistinctTop5ByNumView();
}