package com.service.inventorycatalogue.awsconfig;

import org.apache.http.impl.client.BasicCredentialsProvider;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";

    @Bean
    public SqsClient sqsClient() {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(ACCESS_KEY, SECRET_KEY);
        return SqsClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider
                        .create(awsBasicCredentials)).build();

    }
}
