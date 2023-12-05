package com.bankapp.app.mapper;

import com.bankapp.app.entity.Transaction;
import com.bankapp.app.entity.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto toDto(Transaction transaction);
}
