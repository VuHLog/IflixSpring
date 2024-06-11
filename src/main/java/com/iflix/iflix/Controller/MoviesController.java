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

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping("")
    public Page<MoviesResponse> getMovies(
            @RequestParam(name = "field", required = false, defaultValue = "name") String field,
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

    @GetMapping("/trending")
    public ApiResponse<List<MoviesResponse>> getMovieTrending(@RequestParam(name = "top", required = false, defaultValue = "5") int top){
        return ApiResponse.<List<MoviesResponse>>builder()
                .result(moviesService.getTopTrending(top))
                .build();
    }

    @GetMapping("/topViews")
    public ApiResponse<List<MoviesResponse>> getTopViews(@RequestParam(name = "top", required = false, defaultValue = "10") int top){
        return ApiResponse.<List<MoviesResponse>>builder()
                .result(moviesService.getTopViews(top))
                .build();
    }

    @GetMapping("/TopNewDrama")
    public ApiResponse<List<MoviesResponse>> getTopMovieByNewDrama(@RequestParam(name = "top", required = false, defaultValue = "16") int top){
        return ApiResponse.<List<MoviesResponse>>builder()
                .result(moviesService.getTopNewDrama(top))
                .build();
    }

    @GetMapping("/TopNewSingleMovie")
    public ApiResponse<List<MoviesResponse>> getTopMovieByNewSingleMovie(@RequestParam(name = "top", required = false, defaultValue = "16") int top){
        return ApiResponse.<List<MoviesResponse>>builder()
                .result(moviesService.getTopNewSingleMovie(top))
                .build();
    }

    @GetMapping("/MoviesAboutToShow")
    public ApiResponse<List<MoviesResponse>> getMoviesAboutToShow(@RequestParam(name = "top", required = false, defaultValue = "5") int top){
        return ApiResponse.<List<MoviesResponse>>builder()
                .result(moviesService.getMoviesAboutToShow(top))
                .build();
    }



    @PostMapping("")
    public ApiResponse<MoviesResponse> createMovie(@RequestBody MoviesRequest request){

        return ApiResponse.<MoviesResponse>builder()
                .result(moviesService.addMovie(request))
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
