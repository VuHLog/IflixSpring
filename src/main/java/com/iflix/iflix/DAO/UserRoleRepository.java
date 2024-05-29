package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Role;
import com.iflix.iflix.Entities.User_Role;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<User_Role, String> {
    User_Role findByRole(Role role);

    User_Role findByUser_IdAndRole_Id(String user_id, String role_id);


}
