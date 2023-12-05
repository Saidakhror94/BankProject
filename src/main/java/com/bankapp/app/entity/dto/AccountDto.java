package com.bankapp.app.entity.dto;

import lombok.Data;

@Data
public class AccountDto {
    String name;
    String type;
    String status;
    String balance;
    String createdAt;
}
