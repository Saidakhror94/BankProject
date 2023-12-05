package com.bankapp.app.service;

import com.bankapp.app.entity.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findById (String id);
}
