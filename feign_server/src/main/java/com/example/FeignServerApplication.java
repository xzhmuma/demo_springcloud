package com.example;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignServerApplication.class).web(true).run(args);
    }
}
