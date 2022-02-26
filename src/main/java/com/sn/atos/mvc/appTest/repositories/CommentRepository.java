package com.sn.atos.mvc.appTest.repositories;

import com.sn.atos.mvc.appTest.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
