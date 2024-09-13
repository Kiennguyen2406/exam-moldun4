package com.example.exammoldun4.service.impl;

import com.example.exammoldun4.model.Product;
import com.example.exammoldun4.model.ProductCategory;
import com.example.exammoldun4.repository.IProductCategoryRepository;
import com.example.exammoldun4.service.IProductCategoryService;
import com.example.exammoldun4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private IProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }
}
