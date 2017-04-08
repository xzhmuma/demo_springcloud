package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DiscoveryServerApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryServerApplication.class).web(true).run(args);

    }
}
