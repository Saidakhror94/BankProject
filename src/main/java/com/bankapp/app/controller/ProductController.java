package com.bankapp.app.controller;

import com.bankapp.app.entity.Client;
import com.bankapp.app.entity.Product;
import com.bankapp.app.entity.dto.ClientDto;
import com.bankapp.app.entity.dto.ProductDto;
import com.bankapp.app.mapper.ClientMapper;
import com.bankapp.app.mapper.ProductMapper;
import com.bankapp.app.service.ClientService;
import com.bankapp.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/get/{id}")
    public ProductDto getProduct(@PathVariable("id") String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return productMapper.toDto(optionalProduct.get());
    }
}

