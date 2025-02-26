package com.example.exammoldun4.service.impl;

import com.example.exammoldun4.model.Orders;
import com.example.exammoldun4.repository.IOrderRepository;
import com.example.exammoldun4.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public Orders findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
