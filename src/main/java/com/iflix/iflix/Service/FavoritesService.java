package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.FavoritesRequest;
import com.iflix.iflix.DTO.Request.UserCreationRequest;
import com.iflix.iflix.DTO.Response.FavoritesReponse;
import com.iflix.iflix.DTO.Response.UserResponse;
import com.iflix.iflix.Entities.Favorites;

import java.util.List;

public interface FavoritesService {
    public FavoritesReponse addFavorite(FavoritesRequest request);
    List<FavoritesReponse> getFavoritesByUserId(String userId);

    FavoritesReponse getFavoritesByUserIdAndMovieId(String userId,String movieId);

    void deleteByUserIdAndMovieId(String userId, String movieId);
}
