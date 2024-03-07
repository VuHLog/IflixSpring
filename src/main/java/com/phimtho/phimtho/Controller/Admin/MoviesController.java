package com.phimtho.phimtho.Controller.Admin;

import com.phimtho.phimtho.Entities.Movies;
import com.phimtho.phimtho.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping(value={"","/list"})
    public ResponseEntity<List<Movies>> getAll(){
        return ResponseEntity.ok(List.of(moviesService.findById(1)));
    }
}
