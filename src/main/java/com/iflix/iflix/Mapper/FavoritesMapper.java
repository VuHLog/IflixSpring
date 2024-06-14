package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.FavoritesRequest;
import com.iflix.iflix.DTO.Response.FavoritesReponse;
import com.iflix.iflix.Entities.Favorites;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FavoritesMapper {
    Favorites toFavorite(FavoritesRequest request);

    FavoritesReponse toFavoriteResponse(Favorites favorite);
}
