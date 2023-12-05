package com.bankapp.app.controller;

import com.bankapp.app.entity.Product;
import com.bankapp.app.entity.Transaction;
import com.bankapp.app.entity.dto.ProductDto;
import com.bankapp.app.entity.dto.TransactionDto;
import com.bankapp.app.mapper.ProductMapper;
import com.bankapp.app.mapper.TransactionMapper;
import com.bankapp.app.service.ProductService;
import com.bankapp.app.service.TransactionService;
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
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @GetMapping("/get/{id}")
    public TransactionDto getTransaction(@PathVariable("id") String id) {
        Optional<Transaction> optionalTransaction = transactionService.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return transactionMapper.toDto(optionalTransaction.get());
    }

}
