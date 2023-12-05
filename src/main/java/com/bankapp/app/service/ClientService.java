package com.bankapp.app.service;

import com.bankapp.app.entity.Client;

import java.util.Optional;

public interface ClientService {
    Optional <Client> findById(String id);
}
