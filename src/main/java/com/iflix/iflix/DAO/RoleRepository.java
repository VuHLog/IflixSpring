package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}