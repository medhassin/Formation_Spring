package com.zeus.demo.repositories;

import com.zeus.demo.models.Category;
import com.zeus.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByPriceBetween(double minPrice,double maxPrice);
    List<Product> findByNameContaining(String name);
    List<Product> findByQuantityLessThan(int quantity);
    List<Product> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
    List<Product> findByUpdatedAtBetween(LocalDate startDate, LocalDate endDate);

    //JPQl query to find products by name and category
    @Query("SELECT p FROM Product p WHERE p.name= ?1  AND p.category=?2")
    List<Product> findByNameAndCategory(String name, Category category);
    // Find products by name and price range using native sql
    @Query(value = "SELECT * FROM products WHERE name= ?1 AND price BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Product> searchByNameAndPriceRange(String name,  double minPrice, double maxPrice);

}
