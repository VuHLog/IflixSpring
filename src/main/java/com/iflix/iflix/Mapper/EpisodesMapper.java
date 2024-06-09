package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.EpisodesRequest;
import com.iflix.iflix.DTO.Response.EpisodesResponse;
import com.iflix.iflix.Entities.Episodes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EpisodesMapper {
    
    Episodes toEpisode(EpisodesRequest request);

    EpisodesResponse toEpisodeResponse(Episodes episode);

    void updateEpisode(@MappingTarget Episodes episode, EpisodesRequest request);
}
