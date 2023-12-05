package com.bankapp.app.mapper;

import com.bankapp.app.entity.Client;
import com.bankapp.app.entity.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto (Client client);

}
