package com.bankapp.app.controller;

import com.bankapp.app.entity.Account;
import com.bankapp.app.entity.dto.AccountDto;
import com.bankapp.app.mapper.AccountMapper;
import com.bankapp.app.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(value="/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    @GetMapping("/get/{id}")
    public AccountDto getAccount(@PathVariable("id") String id){
        Optional<Account> accountOptional=accountService.findById(id);
        if (accountOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return accountMapper.toDto(accountOptional.get());
    }
}
