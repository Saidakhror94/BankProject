package com.bankapp.app.service;

import com.bankapp.app.entity.Agreement;

import java.util.Optional;

public interface AgreementService {
    Optional<Agreement> findById(String id);
}
