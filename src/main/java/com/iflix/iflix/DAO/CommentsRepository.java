package com.iflix.iflix.DAO;

import com.iflix.iflix.Entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, String> {
}