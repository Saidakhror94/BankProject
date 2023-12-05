package com.bankapp.app.controller;

import com.bankapp.app.entity.Agreement;
import com.bankapp.app.entity.dto.AgreementDto;
import com.bankapp.app.mapper.AgreementMapper;
import com.bankapp.app.service.AgreementService;
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
@RequestMapping("/agreement")
public class AgreementController {
    private final AgreementService agreementService;
    private final AgreementMapper agreementMapper;

    @GetMapping("/get/{id}")
    public AgreementDto getAgreement(@PathVariable("id")String id){
        Optional<Agreement> optionalAgreement = agreementService.findById(id);
        if (optionalAgreement.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return agreementMapper.toDto(optionalAgreement.get());
    }
}
