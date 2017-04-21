package com.example;

import com.example.repository.base.BaseRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EntityScan(basePackages = {"com.example.entity"})
//指定自己的工厂类
@EnableJpaRepositories(basePackages = {"com.example.repository"}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@SpringBootApplication
public class DiscoveryServerApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryServerApplication.class).web(true).run(args);

    }
}
