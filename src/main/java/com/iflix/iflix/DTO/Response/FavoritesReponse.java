package com.iflix.iflix.DTO.Response;

import com.iflix.iflix.Entities.Movies;
import com.iflix.iflix.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritesReponse {
    private String id;

    private Movies movie;

    private Users user;
}
