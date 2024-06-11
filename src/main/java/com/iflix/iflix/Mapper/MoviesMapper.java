package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.MoviesRequest;
import com.iflix.iflix.DTO.Response.MoviesResponse;
import com.iflix.iflix.Entities.Movies;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public interface MoviesMapper {
    Movies toMovie(MoviesRequest request);
    MoviesResponse toMovieResponse(Movies movie);
    void updateMovie(Movies movie, MoviesRequest request);
}
//
//@Mapper(componentModel = "spring")
//public interface MoviesMapper {
//
//    MoviesMapper INSTANCE = Mappers.getMapper(MoviesMapper.class);
//
//    @Mapping(target = "movie_genres",ignore = true)
//    @Mapping(target = "movie_actors",ignore = true)
////    @Mapping(target = "createdTime", source = "createdTime", qualifiedByName = "stringToTimestamp")
////    @Mapping(target = "modifiedTime", source = "modifiedTime", qualifiedByName = "stringToTimestamp")
//    Movies toMovie(MoviesRequest request);
//
////    @Mapping(target = "createdTime", source = "createdTime", qualifiedByName = "timestampToString")
////    @Mapping(target = "modifiedTime", source = "modifiedTime", qualifiedByName = "timestampToString")
//    MoviesResponse toMovieResponse(Movies movie);
//
//    @Mapping(target = "movie_genres",ignore = true)
//    @Mapping(target = "movie_actors",ignore = true)
////    @Mapping(target = "createdTime", source = "createdTime", qualifiedByName = "stringToTimestamp")
////    @Mapping(target = "modifiedTime", source = "modifiedTime", qualifiedByName = "stringToTimestamp")
//    void updateMovie(@MappingTarget Movies movie, MoviesRequest request);
//
//    @Named("stringToTimestamp")
//    default Timestamp stringToTimestamp(String dateString) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            return new Timestamp(dateFormat.parse(dateString).getTime());
//        } catch (ParseException e) {
//            throw new RuntimeException("Failed to parse date: " + dateString, e);
//        }
//    }
//
//    @Named("timestampToString")
//    default String timestampToString(Timestamp timestamp) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.format(timestamp);
//    }
//}
