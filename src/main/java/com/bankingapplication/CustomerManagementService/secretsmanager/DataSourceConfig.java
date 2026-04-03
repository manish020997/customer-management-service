package com.bankingapplication.CustomerManagementService.secretsmanager;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private final SecretsManagerService secretsManagerService;

    public DataSourceConfig(SecretsManagerService secretsManagerService){
        this.secretsManagerService = secretsManagerService;
    }

    @Bean
    public DataSource dataSource(){
        DbSecret secret = secretsManagerService.getDbSecret();

        String jdbcUrl = String.format("jdbc:postgresql://%s:%d/%s", secret.getHost(), secret.getPort(), secret.getDbname());

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(secret.getUsername());
        dataSource.setPassword(secret.getPassword());
        dataSource.setDriverClassName("org.postgresql.Driver");

        return dataSource;
    }
}
