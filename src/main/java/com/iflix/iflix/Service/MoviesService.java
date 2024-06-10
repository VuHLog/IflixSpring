package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MoviesService {
    public Page<MoviesResponse> getMovies(Pageable pageable);

    public Page<MoviesResponse> getMoviesContains(String s,Pageable pageable);
    public MoviesResponse getById(String id);

    public List<MoviesResponse> getTop5Trending();

    public MoviesResponse addMovie(MoviesRequest request);

    public MoviesResponse updateMovie(String moviesId, MoviesRequest request);

    public void deleteMovie(String moviesId);
}
