package com.iflix.iflix.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

//phim
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String slug;

    @Column
    private String description;

    @Column
    private int duration;

    @Column
    private int episodeCurrent;

//    @Column
//    private int episodeTotal;

    @Column
    private String status;

    @Column
    private String lang;

    @Column
    private int releaseYear;

    @Column
    private int numView;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "movie" )
    @JsonIgnore
    private List<Comments> comments;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Episode> episodes;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Favorites> favorites;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Categories categories;

    @OneToMany(mappedBy = "movie",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private Set<Movie_Genre> movie_genres;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private  Countries country;

    @OneToMany(mappedBy = "movie",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JsonIgnore
    private Set<Movie_Actor> movie_actors;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @JsonIgnore
    private Directors director;

    @OneToOne(mappedBy = "movie")
    @JsonIgnore
    private Rates rate;
}