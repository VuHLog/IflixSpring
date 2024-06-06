package com.iflix.iflix.DTO.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iflix.iflix.Entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoviesRequest {

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

    private Set<Genres> genres;

    private Countries country;
    private Set<Actors> actors;

    private Directors director;
}
