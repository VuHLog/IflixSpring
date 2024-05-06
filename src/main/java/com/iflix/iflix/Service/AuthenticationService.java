package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.AuthenticationRequest;
import com.iflix.iflix.DTO.Response.AuthenticationResponse;
import com.iflix.iflix.Entities.Users;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    public String generateToken(Users user);
}
