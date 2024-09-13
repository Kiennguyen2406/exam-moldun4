package com.example.exammoldun4.repository;

import com.example.exammoldun4.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
