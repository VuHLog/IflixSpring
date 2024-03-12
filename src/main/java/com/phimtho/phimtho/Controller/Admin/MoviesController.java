package com.phimtho.phimtho.Controller.Admin;

import com.phimtho.phimtho.Entities.Movies;
import com.phimtho.phimtho.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping(value = {"","/list"})
    public ResponseEntity<Page<Movies>> getAll(
            @RequestParam(name = "field", required = false,defaultValue = "name") String field,
            @RequestParam(name="page", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name="size", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name="sort",required = false, defaultValue = "ASC") String sort
    ){
        Sort sortable = null;
        if(sort.toUpperCase().equals("ASC")){
            sortable = Sort.by(field).ascending();
        }

        if(sort.toUpperCase().equals("ASC")){
            sortable = Sort.by(field).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortable);
        Page<Movies> moviesPage = moviesService.findMovies(pageable);
        return ResponseEntity.ok(moviesPage);
    }

}
