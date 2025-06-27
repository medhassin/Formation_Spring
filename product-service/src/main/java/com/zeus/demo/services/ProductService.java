package com.zeus.demo.services;

import com.zeus.demo.dto.ProductWithCommentsDto;
import com.zeus.demo.form.AddProductForm;
import com.zeus.demo.form.UpdateProductForm;
import com.zeus.demo.models.Category;
import com.zeus.demo.models.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(AddProductForm Form);
    public List<Product> getAllProducts();
    public List<Product> getProductsByCategory(Category category);
    public Product getProduct(Long id);
    public Product updateProduct(UpdateProductForm form);
    public void deleteProduct(Long id);
    public ProductWithCommentsDto getProductWithComments(Long id) throws Exception;
}
