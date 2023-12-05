package com.bankapp.app.mapper;

import com.bankapp.app.entity.Account;
import com.bankapp.app.entity.dto.AccountDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toDto(Account account);
}
