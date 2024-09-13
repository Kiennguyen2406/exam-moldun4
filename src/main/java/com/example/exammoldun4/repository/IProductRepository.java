package com.example.exammoldun4.repository;

import com.example.exammoldun4.model.Product;
import com.example.exammoldun4.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductCategoryCategoryId(Long categoryId);
}
