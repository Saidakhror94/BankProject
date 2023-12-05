package com.bankapp.app.controller;

import com.bankapp.app.entity.Agreement;
import com.bankapp.app.entity.Client;
import com.bankapp.app.entity.dto.AgreementDto;
import com.bankapp.app.entity.dto.ClientDto;
import com.bankapp.app.mapper.AgreementMapper;
import com.bankapp.app.mapper.ClientMapper;
import com.bankapp.app.service.AgreementService;
import com.bankapp.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping("/get/{id}")
    public ClientDto getClient(@PathVariable("id")String id){
        Optional<Client> optionalClient = clientService.findById(id);
        if (optionalClient.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clientMapper.toDto(optionalClient.get());
    }
}