package com.zeus.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long Id;
    private Long productId;
    private String text;

}
