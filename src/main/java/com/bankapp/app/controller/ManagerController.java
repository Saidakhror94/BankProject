package com.bankapp.app.controller;

import com.bankapp.app.entity.Client;
import com.bankapp.app.entity.Manager;
import com.bankapp.app.entity.dto.ClientDto;
import com.bankapp.app.entity.dto.ManagerDto;
import com.bankapp.app.mapper.ManagerMapper;
import com.bankapp.app.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/manager")
@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;
    private final ManagerMapper managerMapper;

    @GetMapping("/get/{id}")
    public ManagerDto getManager(@PathVariable("id")String id){
        Optional<Manager> optionalManager = managerService.findById(id);
        if (optionalManager.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return managerMapper.toDto(optionalManager.get());
    }
    @RequestMapping(value = "/new", method = {RequestMethod.GET, RequestMethod.POST})
    public  ManagerDto create(@RequestBody ManagerDto managerDto) {
       return managerService.create(managerDto);
    }
}
