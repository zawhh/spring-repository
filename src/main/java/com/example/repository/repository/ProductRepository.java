package com.example.repository.repository;

import com.example.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Warning: this will raise exception if multiple products are found
    Product findByType(String type);

    List<Product> findByDescriptionAndCategory(String description, String category);

    List<Product> findByCategoryAndNameIn(String category, List<String> names);
}
