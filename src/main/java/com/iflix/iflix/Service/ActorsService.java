package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Response.ActorsResponse;

import java.util.List;

public interface ActorsService {
    public List<ActorsResponse> getActors();

    public ActorsResponse getById(String id);
}
