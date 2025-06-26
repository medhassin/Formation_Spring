package com.zeus.demo.services;

import com.zeus.demo.exceptions.MissingEntityException;
import com.zeus.demo.form.AddCommentForm;
import com.zeus.demo.form.UpdateCommentForm;
import com.zeus.demo.models.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(AddCommentForm form);

    Comment updateComment(UpdateCommentForm form) throws MissingEntityException;

    void deleteComment(Long id) throws MissingEntityException;

    Comment getCommentById(Long id) throws MissingEntityException;

    List<Comment>  getComments(Long productId);

    List<Comment>  searchComment(String text);

}
