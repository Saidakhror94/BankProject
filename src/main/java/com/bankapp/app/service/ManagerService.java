package com.bankapp.app.service;

import com.bankapp.app.entity.Manager;
import com.bankapp.app.entity.dto.ManagerDto;

import java.util.Optional;

public interface  ManagerService  {
    Optional<Manager> findById (String id);


    ManagerDto create(ManagerDto managerDto);
}
