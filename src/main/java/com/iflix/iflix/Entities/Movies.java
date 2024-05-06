package com.iflix.iflix.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

//luu phim
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

    @Column
    private int epsisodeTotal;

    @Column
    private String status;

    @Column
    private String lang;

    @Column
    private int releaseYear;

    @Column
    private int numView;


    @Transient
    @JsonIgnore
    private MultipartFile filmImage;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "movie" )
    @JsonIgnore
    private List<Comments> comments;

    @ManyToOne
    @JoinColumn(name = "favorite_id")
    private Favorites favorite;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genres> genres;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private  Countries country;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actors> actors;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Directors director;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actors actor;

    @OneToOne(mappedBy = "movie")
    private Rates rate;
}