package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryServer2Application {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryServer2Application.class).web(true).run(args);

    }
}
