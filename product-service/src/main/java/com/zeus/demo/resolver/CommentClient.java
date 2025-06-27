package com.zeus.demo.resolver;

import com.zeus.demo.dto.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "comment-service",url="${comment.service.url}")
public interface CommentClient {
    @GetMapping("/comments/all")
    List<CommentDto> getCommentsByProductId(@RequestParam("productId")long productId) ;
}
