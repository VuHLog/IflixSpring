package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Response.DirectorsResponse;

import java.util.List;

public interface DirectorsService {
    public List<DirectorsResponse> getDirectors();

    public DirectorsResponse getById(String id);
}
