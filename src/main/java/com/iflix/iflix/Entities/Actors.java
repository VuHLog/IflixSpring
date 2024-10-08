package com.iflix.iflix.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//luu thong tin dien vien
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "actor",cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<Movie_Actor> movie_actors;
}