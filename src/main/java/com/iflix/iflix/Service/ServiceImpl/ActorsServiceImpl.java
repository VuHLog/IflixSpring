package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.ActorsRepository;
import com.iflix.iflix.DTO.Response.ActorsResponse;
import com.iflix.iflix.Mapper.ActorsMapper;
import com.iflix.iflix.Service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    private ActorsRepository actorsRepository;

    @Autowired
    private ActorsMapper actorsMapper;

    @Override
    public ActorsResponse getById(String id) {
        return actorsMapper.toActorsResponse(actorsRepository.findById(id).get());
    }

    @Override
    public List<ActorsResponse> getActors() {
        return actorsRepository.findAll().stream().map(actorsMapper::toActorsResponse).toList();
    }

}
