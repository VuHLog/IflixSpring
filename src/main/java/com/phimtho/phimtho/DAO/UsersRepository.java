package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}