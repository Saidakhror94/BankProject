package com.bankapp.app.service;

import com.bankapp.app.entity.Account;
import com.bankapp.app.entity.Manager;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById (String id);
}
