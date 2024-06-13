package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MoviesService {
    public Page<MoviesResponse> getMovies(Pageable pageable);

    public Page<MoviesResponse> getMoviesByFilter(String field, Integer pageNumber, Integer pageSize, String name, String genre, String country, String category, Integer releaseYear);

    public Page<MoviesResponse> getMoviesContains(String s, Pageable pageable);

    public MoviesResponse getById(String id);

    public MoviesResponse getBySlug(String slug);

    public List<Integer> getAllYear();

    public List<MoviesResponse> getTopTrending(int top);

    public List<MoviesResponse> getTopViews(int top);

    public List<MoviesResponse> getMoviesAboutToShow(int top);

    public List<MoviesResponse> getTopNewDrama(int top);

    public List<MoviesResponse> getTopNewSingleMovie(int top);

    public MoviesResponse addMovie(MoviesRequest request);

    public MoviesResponse updateMovie(String moviesId, MoviesRequest request);

    public void deleteMovie(String moviesId);
}
