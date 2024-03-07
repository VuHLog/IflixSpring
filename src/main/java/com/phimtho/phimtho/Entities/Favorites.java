package com.phimtho.phimtho.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToMany(mappedBy = "favorite")
    private Set<Movies> movies;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
}