package com.example.exammoldun4.service;

import com.example.exammoldun4.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    List<Product> findByProductCategoryId(Long categoryId);
}
