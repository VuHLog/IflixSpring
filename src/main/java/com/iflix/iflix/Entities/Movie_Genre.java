package com.iflix.iflix.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Movie_Genre",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"movie_id", "genre_id"})
        }
)
public class Movie_Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genre;

    public Movie_Genre(Movies movie, Genres genre) {
        this.movie = movie;
        this.genre = genre;
    }
}
