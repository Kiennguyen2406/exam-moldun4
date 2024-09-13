package com.example.exammoldun4.service.impl;

import com.example.exammoldun4.model.Product;
import com.example.exammoldun4.repository.IOrderRepository;
import com.example.exammoldun4.repository.IProductRepository;
import com.example.exammoldun4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByProductCategoryId(Long categoryId) {
        return productRepository.findByProductCategoryCategoryId(categoryId);
    }

}
