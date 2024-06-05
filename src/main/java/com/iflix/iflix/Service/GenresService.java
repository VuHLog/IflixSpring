package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.GenresRequest;
import com.iflix.iflix.DTO.Response.GenresResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenresService {
    public Page<GenresResponse> getGenres(Pageable pageable);

    public Page<GenresResponse> getGenresContains(String s,Pageable pageable);
    public GenresResponse getById(String id);

    public GenresResponse addGenres(GenresRequest request);

    public GenresResponse updateGenres(String genresId, GenresRequest request);

    public void deleteGenres(String genresId);
}
