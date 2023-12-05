package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Transaction;
import com.bankapp.app.repository.TransactionRepository;
import com.bankapp.app.service.TransactionService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    @Override
    public Optional<Transaction> findById(String id) {
        return transactionRepository.findById(Integer.parseInt(id));
    }
}
