package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.AuthenticationRequest;
import com.iflix.iflix.DTO.Request.IntrospectRequest;
import com.iflix.iflix.DTO.Request.LogoutRequest;
import com.iflix.iflix.DTO.Request.RefreshRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.AuthenticationResponse;
import com.iflix.iflix.DTO.Response.IntrospectResponse;
import com.iflix.iflix.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        var res = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(res)
                .build();
    }

    @PostMapping("/google")
    public ApiResponse<AuthenticationResponse> googleLogin(@RequestBody Map<String, String> body) {
        var res = authenticationService.authenticateGoogle(body);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(res)
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var res = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .result(res)
                .build();
    }

    @PostMapping("/refresh")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var res = authenticationService.refreshToken(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(res)
                .build();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> authenticate(@RequestBody LogoutRequest request)
            throws ParseException, JOSEException {
        authenticationService.logout(request);

        return ApiResponse.<Void>builder()
                .build();
    }
}
