package com.bankingapplication.CustomerManagementService.secretsmanager;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DbSecret {
    private String username;
    private String password;
    private String host;
    private Integer port;
    private String dbname;
    private String engine;
}
