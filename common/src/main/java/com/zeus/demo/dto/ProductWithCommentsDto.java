package com.zeus.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductWithCommentsDto {
    private ProductDto product;
    private List<CommentDto> comments;
}
