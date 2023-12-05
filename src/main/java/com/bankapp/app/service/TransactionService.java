package com.bankapp.app.service;

import com.bankapp.app.entity.Transaction;

import java.util.Optional;

public interface TransactionService {
    Optional<Transaction> findById (String id);
}
