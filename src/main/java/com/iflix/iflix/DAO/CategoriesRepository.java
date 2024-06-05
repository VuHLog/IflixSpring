package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, String> {
    boolean existsByName(String name);

    Optional<Categories> findByName(String name);

    Page<Categories> findByNameContainsIgnoreCase(String name, Pageable pageable);
}