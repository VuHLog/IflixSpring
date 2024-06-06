package com.iflix.iflix.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Movie_Actor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"movie_id", "actor_id"})
        }
)
public class Movie_Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actors actor;

    public Movie_Actor(Movies movie, Actors actor) {
        this.movie = movie;
        this.actor = actor;
    }
}
