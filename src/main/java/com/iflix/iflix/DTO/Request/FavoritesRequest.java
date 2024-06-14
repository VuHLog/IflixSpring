package com.iflix.iflix.DTO.Request;

import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Entities.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritesRequest {
    private Movies movie;

    private Users user;
}
