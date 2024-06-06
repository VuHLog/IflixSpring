package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.*;
import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.*;
import com.iflix.iflix.Mapper.MoviesMapper;
import com.iflix.iflix.Service.MoviesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    @Autowired
    private ActorsRepository actorsRepository;

    @Autowired
    private MovieActorRepository movieActorRepository;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private DirectorsRepository directorsRepository;

    @Autowired
    private RatesRepository ratesRepository;

    @Autowired
    private MoviesMapper moviesMapper;

    @Override
    public MoviesResponse getById(String id) {
        return moviesMapper.toMovieResponse(moviesRepository.findById(id).get());
    }

    @Override
    public Page<MoviesResponse> getMovies(Pageable pageable) {
        return moviesRepository.findAll(pageable).map(moviesMapper::toMovieResponse);
    }

    @Override
    public Page<MoviesResponse> getMoviesContains(String s, Pageable pageable) {
        return moviesRepository.findByNameContainsIgnoreCase(s, pageable).map(moviesMapper::toMovieResponse);
    }

    @Override
    public MoviesResponse addMovie(MoviesRequest request) {
        Movies movie = moviesMapper.toMovie(request);

        //xu ly genres request
        Set<Movie_Genre> movie_genres = new HashSet<>();
        request.getGenres().forEach(s -> movie_genres.add(new Movie_Genre(movie,s)));
        movie.setMovie_genres(movie_genres);

        //xu ly actors request
        Set<Movie_Actor> movie_actors = new HashSet<>();
        request.getActors().forEach(s -> movie_actors.add(new Movie_Actor(movie,s)));
        movie.setMovie_actors(movie_actors);

        return moviesMapper.toMovieResponse(moviesRepository.save(movie));
    }

    @Override
    @Transactional
    public MoviesResponse updateMovie(String movieId, MoviesRequest request) {
        Movies movie = moviesRepository.findById(movieId).get();
        moviesMapper.updateMovie(movie, request);

        // xoá movie id trong movie_genre
        movieGenreRepository.deleteByMovie(movie);

        // xoá movie id trong movie_actor
        movieActorRepository.deleteByMovie(movie);

        Set<Movie_Genre> movie_genres = new HashSet<>();
        List<Genres> genresRequest = request.getGenres().stream().toList();
        for(int i=0; i<genresRequest.size();i++){
            movie_genres.add(new Movie_Genre(movie,genresRequest.get(i)));
        }
        movie.setMovie_genres(movie_genres);

        Set<Movie_Actor> movie_actors = new HashSet<>();
        List<Actors> actorsRequest = request.getActors().stream().toList();
        for(int i=0; i<actorsRequest.size();i++){
            movie_actors.add(new Movie_Actor(movie,actorsRequest.get(i)));
        }
        movie.setMovie_actors(movie_actors);

        return moviesMapper.toMovieResponse(moviesRepository.saveAndFlush(movie));
    }

    @Override
    @Transactional
    public void deleteMovie(String movieId) {
        Movies movie = moviesRepository.findById(movieId).get();
        movieGenreRepository.deleteById(movieId);
        movieActorRepository.deleteById(movieId);
        moviesRepository.deleteById(movieId);
    }
}
