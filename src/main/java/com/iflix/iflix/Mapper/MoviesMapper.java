package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.Movies;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MoviesMapper {

    @Mapping(target = "movie_genres",ignore = true)
    @Mapping(target = "movie_actors",ignore = true)
    Movies toMovie(MoviesRequest request);

    MoviesResponse toMovieResponse(Movies movie);

    @Mapping(target = "movie_genres",ignore = true)
    @Mapping(target = "movie_actors",ignore = true)
    void updateMovie(@MappingTarget Movies movie, MoviesRequest request);
}
