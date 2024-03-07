package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}