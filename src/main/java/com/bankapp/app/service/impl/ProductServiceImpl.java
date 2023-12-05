package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Product;
import com.bankapp.app.repository.ProductRepository;
import com.bankapp.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(Integer.parseInt(id));
    }
}
