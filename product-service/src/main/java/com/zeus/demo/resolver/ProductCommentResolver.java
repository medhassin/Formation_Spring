package com.zeus.demo.resolver;

import com.zeus.demo.dto.CommentDto;
import com.zeus.demo.dto.ProductWithCommentsDto;
import com.zeus.demo.mapper.ProductMapper;
import com.zeus.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ProductCommentResolver {

    @Autowired
    private CommentClient commentClient;

    public ProductWithCommentsDto resolveData(Product product){
        String token = "Bearer my-test-token-123";
        List<CommentDto> comments = commentClient.getCommentsByProductId(product.getId(),token);
        ProductWithCommentsDto productWithComments = new ProductWithCommentsDto();
        productWithComments.setProduct(ProductMapper.of(product));
        productWithComments.setComments(comments);
        return productWithComments;
    }
}
