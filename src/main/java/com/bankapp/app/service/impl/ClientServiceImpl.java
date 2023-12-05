package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Client;
import com.bankapp.app.repository.ClientRepository;
import com.bankapp.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Optional<Client> findById(String id) {
        return clientRepository.findById(Integer.parseInt(id));
    }
}
