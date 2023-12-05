package com.bankapp.app.mapper;

import com.bankapp.app.entity.Manager;
import com.bankapp.app.entity.dto.ManagerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    ManagerDto toDto(Manager manager);

    Manager toEntity(ManagerDto managerDto);
}
