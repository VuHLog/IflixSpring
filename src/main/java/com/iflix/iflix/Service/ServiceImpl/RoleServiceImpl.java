package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.GenresRepository;
import com.iflix.iflix.DAO.RoleRepository;
import com.iflix.iflix.DTO.Request.GenresRequest;
import com.iflix.iflix.DTO.Response.RoleResponse;
import com.iflix.iflix.DTO.Response.RoleResponse;
import com.iflix.iflix.Entities.Genres;
import com.iflix.iflix.Mapper.GenresMapper;
import com.iflix.iflix.Mapper.RoleMapper;
import com.iflix.iflix.Service.GenresService;
import com.iflix.iflix.Service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleResponse getById(String id) {
        return roleMapper.toRoleResponse(roleRepository.findById(id).get());
    }

    @Override
    public List<RoleResponse> getRoles() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

}
