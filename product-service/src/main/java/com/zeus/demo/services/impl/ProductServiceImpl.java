package com.zeus.demo.services.impl;

import com.zeus.demo.dto.ProductWithCommentsDto;
import com.zeus.demo.form.AddProductForm;
import com.zeus.demo.form.UpdateProductForm;
import com.zeus.demo.models.Category;
import com.zeus.demo.models.Product;
import com.zeus.demo.repositories.ProductRepository;
import com.zeus.demo.resolver.ProductCommentResolver;
import com.zeus.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCommentResolver resolver ;

    @Override
    public Product addProduct(AddProductForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setQuantity(form.getQuantity());
        product.setCategory(form.getCategory());
        product.setCreatedAt(LocalDate.now());
        product.setUpdatedAt(LocalDate.now());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product getProduct(Long id) {
        return getProductById(id);
    }

    @Override
    public Product updateProduct(UpdateProductForm form) {
        Product product = getProductById(form.getId());
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setQuantity(form.getQuantity());
        product.setCategory(form.getCategory());
        product.setUpdatedAt(LocalDate.now());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Override
    public ProductWithCommentsDto getProductWithComments(Long id) throws Exception {
        Product product = getProductById(id);
        return resolver.resolveData(product);
    }
}
