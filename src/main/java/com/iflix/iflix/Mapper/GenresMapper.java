package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.GenresRequest;
import com.iflix.iflix.DTO.Response.GenresResponse;
import com.iflix.iflix.Entities.Genres;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GenresMapper {

    Genres toGenres(GenresRequest request);

    GenresResponse toGenresResponse(Genres genres);

    void updateGenres(@MappingTarget Genres genres, GenresRequest request);
}
