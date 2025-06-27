package com.zeus.demo.controllers;

import com.zeus.demo.dto.ProductDto;
import com.zeus.demo.dto.ProductWithCommentsDto;
import com.zeus.demo.form.AddProductForm;
import com.zeus.demo.form.UpdateProductForm;
import com.zeus.demo.mapper.ProductMapper;
import com.zeus.demo.models.Category;
import com.zeus.demo.models.Product;
import com.zeus.demo.services.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ProductDto addProduct(@ModelAttribute AddProductForm form) {
        Product product = productService.addProduct(form);
        return ProductMapper.of(product);
    }

    @GetMapping("/all")
    public List<ProductDto> getProducts() {
        List<Product> products = productService.getAllProducts();
        return products.stream()
                .map(ProductMapper::of)
                .collect(Collectors.toList());
    }
    @GetMapping("/get")
    public ProductDto getProductById(@Parameter(description = "The product's ID.") @RequestParam Long id) {
        Product product= productService.getProduct(id);
        return ProductMapper.of(product);
    }
    @GetMapping("/get-with-path-variable/{idp}")
    public ProductDto getProductByIdUsingPathVariable(@PathVariable(name ="idp") Long id) {
        Product product= productService.getProduct(id);
        return ProductMapper.of(product);
    }

    @GetMapping("/category")
    public List<ProductDto> getProductsByCategory(@Parameter(description = "the category of the product") @RequestParam Category category) {
        List<Product> products= productService.getProductsByCategory(category);
        return  products.stream().
                map(ProductMapper::of).
                collect(Collectors.toList());
    }
    @PutMapping("/update")
    public ProductDto updateProduct( @ModelAttribute UpdateProductForm form) {
        Product product = productService.updateProduct(form);
        return ProductMapper.of(product);
    }

    @DeleteMapping("/delete")
    public Map<String,Boolean> deleteProduct(@Parameter(description = "The id of the product ") @RequestParam Long id) {
        productService.deleteProduct(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

    @GetMapping("/get-with-comments")
    public ProductWithCommentsDto getProductWithComments(@Parameter(description = "The product's ID.") @RequestParam Long id) throws Exception{
        ProductWithCommentsDto product= productService.getProductWithComments(id) ;
        return product;
    }
}

