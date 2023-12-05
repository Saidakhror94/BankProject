package com.bankapp.app.mapper;

import com.bankapp.app.entity.Agreement;
import com.bankapp.app.entity.dto.AgreementDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    AgreementDto toDto(Agreement agreement);
}
