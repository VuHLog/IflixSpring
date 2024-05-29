package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.RoleRepository;
import com.iflix.iflix.DAO.UserRoleRepository;
import com.iflix.iflix.DAO.UsersRepository;
import com.iflix.iflix.DTO.Request.UserCreationRequest;
import com.iflix.iflix.DTO.Request.UserUpdateRequest;
import com.iflix.iflix.DTO.Response.UserResponse;
import com.iflix.iflix.Entities.Role;
import com.iflix.iflix.Entities.User_Role;
import com.iflix.iflix.Entities.Users;
import com.iflix.iflix.Exception.AppException;
import com.iflix.iflix.Exception.ErrorCode;
import com.iflix.iflix.Mapper.UserMapper;
import com.iflix.iflix.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getById(String id) {
        return userMapper.toUserResponse(usersRepository.findById(id).get());
    }

    @Override
    public UserResponse addUser(UserCreationRequest request) {
        if(usersRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);


        Users user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<User_Role> user_roles = new HashSet<>();
        User_Role user_role = new User_Role();
        if(request.getUser_roles() == null)
            user_role.setRole(roleRepository.findByRoleName("User"));
            user_role.setUser(user);
            user_roles.add(user_role);
            user.setUser_roles(user_roles);

        return userMapper.toUserResponse(usersRepository.save(user));
    }

    @PreAuthorize("returnObject.username == authentication.name")
    @Override
    public Page<UserResponse> getUsers(Pageable pageable) {
        return usersRepository.findAll(pageable).map(userMapper::toUserResponse);
    }

    public UserResponse getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Users user = usersRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        Users user = usersRepository.findById(userId).get();
        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toUserResponse(usersRepository.saveAndFlush(user));
    }

    @Override
    public void deleteUser(String userId) {
        usersRepository.deleteById(userId);
    }
}
