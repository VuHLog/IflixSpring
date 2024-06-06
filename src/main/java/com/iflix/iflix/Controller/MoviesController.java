package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @PostMapping("")
    public ApiResponse<MoviesResponse> createMovie(@RequestBody MoviesRequest request){

        return ApiResponse.<MoviesResponse>builder()
                .result(moviesService.addMovie(request))
                .build();
    }

    @GetMapping("")
    public Page<MoviesResponse> getMovies(
            @RequestParam(name = "field", required = false, defaultValue = "id") String field,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "search", required = false, defaultValue = "") String search
    ){

        Sort sortable = null;
        if(sort.toUpperCase().equals("ASC")){
            sortable = Sort.by(field).ascending();
        }
        if(sort.toUpperCase().equals("DESC")){
            sortable = Sort.by(field).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortable);
        Page<MoviesResponse> movies = null;
        if(!search.trim().equals("")){
            movies = moviesService.getMoviesContains(search,pageable);
        }else movies = moviesService.getMovies(pageable);
        return movies;
    }

    @GetMapping("/{movieId}")
    public ApiResponse<MoviesResponse> getMovie(@PathVariable String movieId){
        return ApiResponse.<MoviesResponse>builder()
                .result(moviesService.getById(movieId))
                .build();
    }

    @PutMapping("/{movieId}")
    public ApiResponse<MoviesResponse> updateMovie(@PathVariable String movieId,@RequestBody MoviesRequest request){
        return ApiResponse.<MoviesResponse>builder()
                .result(moviesService.updateMovie(movieId,request))
                .build();
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
    public ApiResponse<String> deleteMovie(@PathVariable String movieId){
        moviesService.deleteMovie(movieId);
        return ApiResponse.<String>builder()
                .result("Movie has been deleted")
                .build();
    }

}
