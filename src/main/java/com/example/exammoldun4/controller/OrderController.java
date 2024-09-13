package com.example.exammoldun4.controller;

import com.example.exammoldun4.model.Orders;
import com.example.exammoldun4.model.Product;
import com.example.exammoldun4.model.ProductCategory;
import com.example.exammoldun4.service.IOrderService;
import com.example.exammoldun4.service.IProductCategoryService;
import com.example.exammoldun4.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductCategoryService productCategoryService;

    @GetMapping
    public String showList(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("orderDate").descending());
        Page<Orders> orders = orderService.findAll(pageable);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Orders order : orders) {
            String formattedDate = order.getOrderDate().format(formatter);
            order.setFormattedDate(formattedDate);
        }

        model.addAttribute("orders", orders);
        return "orders/list";
    }


    @GetMapping("/{id}/edit")
    public String editOrder(@PathVariable("id") Long id, Model model) {
        Optional<Orders> orderOpt = orderService.findById(id);
        if (!orderOpt.isPresent()) {
            // Handle order not found, e.g., by redirecting to a not found page or showing an error
            return "redirect:/orders";
        }
        Orders order = orderOpt.get(); // Unwrap the Optional
        List<Product> products = productService.findAll();
        List<ProductCategory> productCategories = productCategoryService.findAll();
        model.addAttribute("order", order); // Add the Orders object directly
        model.addAttribute("products", products);
        model.addAttribute("productTypes", productCategories);
        return "orders/edit";
    }

    @PostMapping("/{id}/update")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute Orders order) {
        Orders existingOrder = orderService.findOrderById(id);
        if (existingOrder != null) {
            existingOrder.setOrderDate(existingOrder.getOrderDate());
            existingOrder.setQuantity(existingOrder.getQuantity());
            existingOrder.setProduct(existingOrder.getProduct());
            orderService.save(existingOrder);
        }
        return "redirect:/orders";
    }
    }
