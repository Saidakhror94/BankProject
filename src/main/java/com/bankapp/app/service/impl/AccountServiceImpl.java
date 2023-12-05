package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Account;
import com.bankapp.app.repository.AccountRepository;
import com.bankapp.app.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(Integer.parseInt(id));
    }
}
