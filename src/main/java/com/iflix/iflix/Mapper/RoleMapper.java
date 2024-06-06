package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.UserCreationRequest;
import com.iflix.iflix.DTO.Request.UserUpdateRequest;
import com.iflix.iflix.DTO.Response.RoleResponse;
import com.iflix.iflix.DTO.Response.UserResponse;
import com.iflix.iflix.Entities.Role;
import com.iflix.iflix.Entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toRoleResponse(Role role);
}
