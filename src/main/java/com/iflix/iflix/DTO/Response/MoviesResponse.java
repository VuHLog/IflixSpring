package com.iflix.iflix.DTO.Response;

import com.iflix.iflix.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoviesResponse {
    private String id;

    private String name;

    private String slug;

    private String description;

    private int duration;

    private int episodeCurrent;

//    private int episodeTotal;

    private String status;

    private String lang;

    private int releaseYear;

    private int numView;

    private String imageUrl;

    private Categories categories;

    private Set<Movie_Genre> movie_genres;

    private Countries country;
    private Set<Movie_Actor> movie_actors;

    private Directors director;

    private Rates rate;
}
