package com.zeus.demo.repositories;

import com.zeus.demo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByText(String text);
    List<Comment> findByProductId(Long productId);

}
