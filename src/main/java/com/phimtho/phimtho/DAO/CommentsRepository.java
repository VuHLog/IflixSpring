package com.phimtho.phimtho.DAO;

import com.phimtho.phimtho.Entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}