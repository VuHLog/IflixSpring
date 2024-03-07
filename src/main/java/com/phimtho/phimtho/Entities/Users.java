package com.phimtho.phimtho.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToMany(mappedBy = "user" )
    private List<Comments> comments;

    @OneToOne(mappedBy = "user")
    private Favorites favorite;

    @OneToMany(mappedBy = "user")
    private Set<Rates> rates;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}