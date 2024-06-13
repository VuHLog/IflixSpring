package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Genres;
import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movies, String>, JpaSpecificationExecutor<Movies> {
    boolean existsByName(String name);

    Optional<Movies> findByName(String name);

    Page<Movies> findByNameContainsIgnoreCase(String name, Pageable pageable);

    Page<Movies> findAll(Specification<Movies> spec, Pageable pageable);

    @Query(value = "select * from movies as m order by num_view desc OFFSET 0 ROWS FETCH FIRST :top ROWS ONLY", nativeQuery = true)
    List<Movies> findDistinctTopByNumView(@Param("top") int top);

    @Query(value = "select m.*, c.name as category_name from movies as m join categories as c on m.category_id = c.id where c.name = N'Phim Bộ' order by modified_time desc OFFSET 0 ROWS FETCH FIRST :top ROWS ONLY", nativeQuery = true)
    List<Movies> findTopByNewDrama(@Param("top") int top);

    @Query(value = "select m.*, c.name as category_name from movies as m join categories as c on m.category_id = c.id where c.name = N'Phim Lẻ' order by modified_time desc OFFSET 0 ROWS FETCH FIRST :top ROWS ONLY", nativeQuery = true)
    List<Movies> findTopByNewSingleMovie(@Param("top") int top);

    @Query(value = "select * from movies as m\n" + "where m.status= N'Sắp chiếu'\n" + "order by created_time desc\n" + "OFFSET 0 ROWS FETCH FIRST :top ROWS ONLY", nativeQuery = true)
    List<Movies> findByMovieAboutToShow(@Param("top") int top);

    Movies findBySlug(String slug);

    @Query(value = "select distinct release_year from movies order by release_year desc",nativeQuery = true)
    List<Integer> findAllYear();


}