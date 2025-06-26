package com.zeus.demo.controllers;

import com.zeus.demo.dto.CommentDto;
import com.zeus.demo.exceptions.MissingEntityException;
import com.zeus.demo.form.AddCommentForm;
import com.zeus.demo.form.UpdateCommentForm;
import com.zeus.demo.mapper.CommentMapper;
import com.zeus.demo.models.Comment;
import com.zeus.demo.services.CommentService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public CommentDto addComment(@ModelAttribute AddCommentForm form) {
        Comment comment = commentService.addComment(form);
        return CommentMapper.of(comment);
    }

    @GetMapping("/get-with-path-variable/{idp}")
    public CommentDto getCommentsById(@PathVariable(name ="idp") Long id) throws MissingEntityException {
        Comment comment= commentService.getCommentById(id);
        return CommentMapper.of(comment);
    }

    @GetMapping("/search")
    public List<CommentDto> searchComment(@Parameter(description = "the category of the comment") @RequestParam String text) {
        List<Comment> comments= commentService.searchComment(text);
        return  comments.stream().
                map(CommentMapper::of).
                collect(Collectors.toList());
    }
    @PutMapping("/update")
    public CommentDto updateComment( @ModelAttribute UpdateCommentForm form) throws MissingEntityException {
        Comment comment = commentService.updateComment(form);
        return CommentMapper.of(comment);
    }

    @DeleteMapping("/delete")
    public Map<String,Boolean> deleteComment(@Parameter(description = "The id of the comment ") @RequestParam Long id) throws MissingEntityException {
        commentService.deleteComment(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


}

