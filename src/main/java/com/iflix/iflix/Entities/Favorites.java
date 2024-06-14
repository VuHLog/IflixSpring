package com.iflix.iflix.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//luu phim yeu thich
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}