package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}