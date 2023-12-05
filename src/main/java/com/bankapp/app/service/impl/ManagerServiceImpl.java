package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Manager;
import com.bankapp.app.entity.dto.ManagerDto;
import com.bankapp.app.mapper.ManagerMapper;
import com.bankapp.app.repository.ManagerRepository;
import com.bankapp.app.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    @Override
    public Optional<Manager> findById(String id) {
        return managerRepository.findById(Integer.parseInt(id));
    }

    @Override
    public ManagerDto create(ManagerDto managerDto) {
        Manager manager = managerMapper.toEntity(managerDto);

        manager = managerRepository.save(manager);

        return managerMapper.toDto(manager);
    }
}
