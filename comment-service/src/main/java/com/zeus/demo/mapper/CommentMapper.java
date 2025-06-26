package com.zeus.demo.mapper;

import com.zeus.demo.dto.CommentDto;
import com.zeus.demo.models.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {
    public static CommentDto of(Comment Comment) {
        if(Comment == null) {
            return null;
        }
        CommentDto commentDto = new CommentDto();
        commentDto.setId(Comment.getId());
        commentDto.setText(Comment.getText());
        commentDto.setProductId(Comment.getProductId());
        return commentDto;
    }
    public static List<CommentDto> of(List<Comment> comments) {
        if(comments == null || comments.isEmpty()) {
            return new ArrayList<>();
        }
        return comments.stream()
                .map(CommentMapper::of)
                .collect(Collectors.toList());
    }
}
