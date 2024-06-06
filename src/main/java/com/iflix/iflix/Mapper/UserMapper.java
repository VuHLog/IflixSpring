package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.UserCreationRequest;
import com.iflix.iflix.DTO.Request.UserUpdateRequest;
import com.iflix.iflix.DTO.Response.UserResponse;
import com.iflix.iflix.Entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "user_roles",ignore = true)
    Users toUser(UserCreationRequest request);

    UserResponse toUserResponse(Users user);

    @Mapping(target = "user_roles", ignore = true)
    void updateUser(@MappingTarget Users user, UserUpdateRequest request);
}
