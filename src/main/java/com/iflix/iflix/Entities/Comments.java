package com.iflix.iflix.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//luu binh luan nguoi dung
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
}