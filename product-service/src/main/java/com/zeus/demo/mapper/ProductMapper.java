package com.zeus.demo.mapper;

import com.zeus.demo.dto.ProductDto;
import com.zeus.demo.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductDto of(Product Product) {
        if(Product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(Product.getId());
        productDto.setName(Product.getName());
        productDto.setPrice(Product.getPrice());
        productDto.setDescription(Product.getDescription());
        productDto.setQuantity(Product.getQuantity());
        productDto.setCategory(Product.getCategory()!= null ? Product.getCategory().name():null);
        return productDto;
    }
    public static List<ProductDto> of(List<Product> products) {
        if(products == null || products.isEmpty()) {
            return new ArrayList<>();
        }
        return products.stream()
                .map(ProductMapper::of)
                .collect(Collectors.toList());
    }
}
