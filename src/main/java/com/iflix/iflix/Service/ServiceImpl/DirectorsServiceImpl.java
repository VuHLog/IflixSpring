package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.DirectorsRepository;
import com.iflix.iflix.DTO.Response.DirectorsResponse;
import com.iflix.iflix.Mapper.DirectorsMapper;
import com.iflix.iflix.Service.DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorsServiceImpl implements DirectorsService {

    @Autowired
    private DirectorsRepository directorsRepository;

    @Autowired
    private DirectorsMapper directorsMapper;

    @Override
    public DirectorsResponse getById(String id) {
        return directorsMapper.toDirectorsResponse(directorsRepository.findById(id).get());
    }

    @Override
    public List<DirectorsResponse> getDirectors() {
        return directorsRepository.findAll().stream().map(directorsMapper::toDirectorsResponse).toList();
    }

}
