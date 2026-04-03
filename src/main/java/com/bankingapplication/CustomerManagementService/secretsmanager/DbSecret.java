package com.bankingapplication.CustomerManagementService.secretsmanager;

import lombok.Data;

@Data
public class DbSecret {
    private String username;
    private String password;
    private String host;
    private Integer port;
    private String dbname;
}
