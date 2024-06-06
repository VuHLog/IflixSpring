package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Response.ActorsResponse;
import com.iflix.iflix.DTO.Response.DirectorsResponse;
import com.iflix.iflix.Entities.Actors;
import com.iflix.iflix.Entities.Directors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorsMapper {

    DirectorsResponse toDirectorsResponse(Directors directors);
}
