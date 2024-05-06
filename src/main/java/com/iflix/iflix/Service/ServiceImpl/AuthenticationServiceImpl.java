package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.UsersRepository;
import com.iflix.iflix.DTO.Request.AuthenticationRequest;
import com.iflix.iflix.Exception.AppException;
import com.iflix.iflix.Exception.ErrorCode;
import com.iflix.iflix.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean authentication(AuthenticationRequest request) {
        var user = usersRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
