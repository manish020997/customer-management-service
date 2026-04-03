package com.bankingapplication.CustomerManagementService.secretsmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Service
public class SecretsManagerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public DbSecret getDbSecret(){
        String secretName = System.getenv("DB_SECRET_NAME");
        String region = System.getenv("AWS_REGION");

        if (secretName == null || secretName.isEmpty()){
            throw new IllegalStateException("DB_SECRET_NAME is missing");
        }

        if (region == null || region.isEmpty()){
            throw new IllegalStateException("region is missing");
        }

        try(SecretsManagerClient client = SecretsManagerClient.builder().region(Region.of(region)).build()){
            GetSecretValueRequest req = GetSecretValueRequest.builder()
                    .secretId(secretName).build();
            GetSecretValueResponse res = client.getSecretValue(req);
            String secretJson = res.secretString();
            return  objectMapper.readValue(secretJson, DbSecret.class);
        } catch (Exception e){
            throw new RuntimeException("Failed to fetch secret from AWS secrets manager", e);
        }
    }
}
