package com.iflix.iflix.DTO.Request;

import com.iflix.iflix.Entities.Movies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenresRequest {
    private String name;

    private String slug;
}
