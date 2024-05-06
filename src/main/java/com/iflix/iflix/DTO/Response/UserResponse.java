package com.iflix.iflix.DTO.Response;

import com.iflix.iflix.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String username;

    private String password;

    private String email;

    private String phone;

    private Role role;
}
