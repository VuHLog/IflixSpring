package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Response.ActorsResponse;
import com.iflix.iflix.Entities.Actors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorsMapper {

    ActorsResponse toActorsResponse(Actors actor);
}
