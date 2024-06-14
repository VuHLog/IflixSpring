package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.FavoritesRepository;
import com.iflix.iflix.DTO.Request.FavoritesRequest;
import com.iflix.iflix.DTO.Response.FavoritesReponse;
import com.iflix.iflix.Entities.Favorites;
import com.iflix.iflix.Mapper.FavoritesMapper;
import com.iflix.iflix.Service.FavoritesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public FavoritesReponse addFavorite(FavoritesRequest request) {
        Favorites favorite = favoritesMapper.toFavorite(request);
        return favoritesMapper.toFavoriteResponse(favoritesRepository.save(favorite));
    }

    @Override
    public List<FavoritesReponse> getFavoritesByUserId(String userId) {
        return favoritesRepository.findByUserId(userId).stream().map(favoritesMapper::toFavoriteResponse).toList();
    }

    @Override
    public FavoritesReponse getFavoritesByUserIdAndMovieId(String userId, String movieId) {
        Favorites favorite = favoritesRepository.findByUserIdAndMovieId(userId, movieId);
        return favoritesMapper.toFavoriteResponse(favorite);
    }

    @Override
    @Transactional
    public void deleteByUserIdAndMovieId(String userId, String movieId) {
        favoritesRepository.deleteByUserIdAndMovieId(userId,movieId);
    }
}
