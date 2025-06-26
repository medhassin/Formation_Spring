package com.zeus.demo.services.impl;

import com.zeus.demo.exceptions.MissingEntityException;
import com.zeus.demo.form.AddCommentForm;
import com.zeus.demo.form.UpdateCommentForm;
import com.zeus.demo.models.Comment;
import com.zeus.demo.repositories.CommentRepository;
import com.zeus.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(AddCommentForm form) {
        Comment comment = new Comment();
        comment.setText(form.getText());
        comment.setProductId(form.getProductId());
        comment.setCreatedAt(LocalDate.now());
        comment.setUpdateAt(LocalDate.now());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(UpdateCommentForm form) throws MissingEntityException  {
        Comment comment = getCommentById(form.getId());
        comment.setText(form.getText());
        comment.setProductId(form.getId());
        comment.setUpdateAt(LocalDate.now());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) throws MissingEntityException  {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);

    }

    @Override
    public Comment getCommentById(Long id) throws MissingEntityException {
        return commentRepository.findById(id).orElseThrow(
                () -> new MissingEntityException("Comment not found with id:" + id )
        );
    }

    @Override
    public List<Comment> getComments(Long productId) {
        return List.of();
    }

    @Override
    public List<Comment> searchComment(String text) {
        return commentRepository.findByText(text);
    }

}
