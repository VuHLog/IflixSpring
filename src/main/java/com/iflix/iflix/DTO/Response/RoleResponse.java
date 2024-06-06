package com.iflix.iflix.DTO.Response;

import com.iflix.iflix.Entities.User_Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponse {
    private String id;
    private String roleName;
}
