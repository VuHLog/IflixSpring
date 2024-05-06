package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.AuthenticationRequest;

public interface AuthenticationService {
    boolean authentication(AuthenticationRequest request);
}
