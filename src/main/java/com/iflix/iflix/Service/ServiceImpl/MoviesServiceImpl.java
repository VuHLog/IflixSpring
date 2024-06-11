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

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private EpisodesRepository episodesRepository;

    @Autowired
    private MoviesMapper moviesMapper;

    @Override
    public MoviesResponse getById(String id) {
        return moviesMapper.toMovieResponse(moviesRepository.findById(id).get());
    }

    @Override
    public List<MoviesResponse> getTopTrending(int top) {
        return moviesRepository.findDistinctTopByNumView(top).stream().map(moviesMapper::toMovieResponse).toList();
    }

    @Override
    public List<MoviesResponse> getTopViews(int top) {
        return moviesRepository.findDistinctTopByNumView(top).stream().map(moviesMapper::toMovieResponse).toList();
    }

    @Override
    public List<MoviesResponse> getMoviesAboutToShow(int top) {
        return moviesRepository.findByMovieAboutToShow(top).stream().map(moviesMapper::toMovieResponse).toList();
    }

    @Override
    public List<MoviesResponse> getTopNewDrama(int top) {
        return moviesRepository.findTopByNewDrama(top).stream().map(moviesMapper::toMovieResponse).toList();
    }

    @Override
    public List<MoviesResponse> getTopNewSingleMovie(int top) {
        return moviesRepository.findTopByNewSingleMovie(top).stream().map(moviesMapper::toMovieResponse).toList();
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

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        // Chuyển đổi LocalDateTime sang Timestamp
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        movie.setCreatedTime(timestamp);
        movie.setModifiedTime(timestamp);

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
        movieGenreRepository.deleteByMovieId(movieId);
        movieActorRepository.deleteByMovieId(movieId);
        episodesRepository.deleteByMovieId(movieId);
        moviesRepository.deleteById(movieId);
    }
}
