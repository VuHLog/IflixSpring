package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Role;
import com.iflix.iflix.Entities.User_Role;
import com.iflix.iflix.Entities.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<User_Role, String> {
    User_Role findByUser_IdAndRole_Id(String id, String id1);

    @Modifying
    @Query("DELETE FROM User_Role ur WHERE ur.user = :user")
    void deleteByUser(Users user);

    @Modifying
    @Query(value = "DELETE ur from user_role as ur where ur.user_id = :userId",nativeQuery = true)
    void deleteByUserId(String userId);
}
