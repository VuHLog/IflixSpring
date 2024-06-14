package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.FavoritesRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.FavoritesReponse;
import com.iflix.iflix.Service.FavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@Slf4j
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;

    @PostMapping("")
    public ApiResponse<FavoritesReponse> createUser(@RequestBody FavoritesRequest request){

        return ApiResponse.<FavoritesReponse>builder()
                .result(favoritesService.addFavorite(request))
        .build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<List<FavoritesReponse>> getFavoritesByUserId(
            @PathVariable String userId
    ){
        return  ApiResponse.<List<FavoritesReponse>>builder()
                .result(favoritesService.getFavoritesByUserId(userId))
                .build();
    }

    @GetMapping("")
    public ApiResponse<FavoritesReponse> getFavoritesByUserIdAndMovieId(
            @RequestParam(name = "userId", required = true) String userId,
            @RequestParam(name = "movieId", required = true) String movieId
    ){
        return  ApiResponse.<FavoritesReponse>builder()
                .result(favoritesService.getFavoritesByUserIdAndMovieId(userId,movieId))
                .build();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ApiResponse<String> deleteFavoriteByUserIdAndMovieId(
            @RequestParam(name = "userId", required = true) String userId,
            @RequestParam(name = "movieId", required = true) String movieId
    ){
        favoritesService.deleteByUserIdAndMovieId(userId,movieId);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }
}
