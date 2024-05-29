package com.iflix.iflix.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToMany(mappedBy = "user" )
    @JsonIgnore
    private List<Comments> comments;

    @OneToOne(mappedBy = "user")
    private Favorites favorite;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Rates> rates;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL,CascadeType.MERGE})
    private Set<User_Role> user_roles;
}