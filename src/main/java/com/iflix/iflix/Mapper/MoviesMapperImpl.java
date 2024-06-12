package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.Movie_Actor;
import com.iflix.iflix.Entities.Movie_Genre;
import com.iflix.iflix.Entities.Movies;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class MoviesMapperImpl implements MoviesMapper {

    @Override
    public Movies toMovie(MoviesRequest request) {
        if ( request == null ) {
            return null;
        }

        Movies movies = new Movies();

        movies.setName( request.getName() );
        movies.setSlug( request.getSlug() );
        movies.setDescription( request.getDescription() );
        movies.setDuration( request.getDuration() );
        movies.setEpisodeTotal( request.getEpisodeTotal() );
        movies.setEpisodeCurrent( request.getEpisodeCurrent() );
        movies.setStatus( request.getStatus() );
        movies.setLang( request.getLang() );
        movies.setReleaseYear( request.getReleaseYear() );
        movies.setNumView( request.getNumView() );
        movies.setImageUrl( request.getImageUrl() );
        movies.setCategories( request.getCategories() );
        movies.setCountry( request.getCountry() );
        movies.setDirector( request.getDirector() );

        return movies;
    }

    @Override
    public MoviesResponse toMovieResponse(Movies movie) {
        if ( movie == null ) {
            return null;
        }

        MoviesResponse.MoviesResponseBuilder moviesResponse = MoviesResponse.builder();

        moviesResponse.id( movie.getId() );
        moviesResponse.name( movie.getName() );
        moviesResponse.slug( movie.getSlug() );
        moviesResponse.description( movie.getDescription() );
        moviesResponse.duration( movie.getDuration() );
        moviesResponse.episodeTotal( movie.getEpisodeTotal() );
        moviesResponse.episodeCurrent( movie.getEpisodeCurrent() );
        moviesResponse.status( movie.getStatus() );
        moviesResponse.lang( movie.getLang() );
        moviesResponse.releaseYear( movie.getReleaseYear() );
        moviesResponse.numView( movie.getNumView() );
        moviesResponse.imageUrl( movie.getImageUrl() );
        moviesResponse.categories( movie.getCategories() );
        Set<Movie_Genre> set = movie.getMovie_genres();
        if ( set != null ) {
            moviesResponse.movie_genres( new LinkedHashSet<Movie_Genre>( set ) );
        }
        moviesResponse.country( movie.getCountry() );
        Set<Movie_Actor> set1 = movie.getMovie_actors();
        if ( set1 != null ) {
            moviesResponse.movie_actors( new LinkedHashSet<Movie_Actor>( set1 ) );
        }
        moviesResponse.director( movie.getDirector() );

        return moviesResponse.build();
    }

    @Override
    public void updateMovie(Movies movie, MoviesRequest request) {
        if ( request == null ) {
            return;
        }

        movie.setName( request.getName() );
        movie.setSlug( request.getSlug() );
        movie.setDescription( request.getDescription() );
        movie.setDuration( request.getDuration() );
        movie.setEpisodeTotal( request.getEpisodeTotal() );
        movie.setEpisodeCurrent( request.getEpisodeCurrent() );
        movie.setStatus( request.getStatus() );
        movie.setLang( request.getLang() );
        movie.setReleaseYear( request.getReleaseYear() );
        movie.setNumView( request.getNumView() );
        movie.setImageUrl( request.getImageUrl() );
        movie.setCategories( request.getCategories() );
        movie.setCountry( request.getCountry() );
        movie.setDirector( request.getDirector() );
    }

}
