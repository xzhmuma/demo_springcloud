package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ChuChen on 2017/4/3.
 */
@RestController
public class MainController {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        String a = restTemplate.getForEntity("http://discovery_service/add?a=10&b=20", String.class).getBody();
        System.out.println(a);

        return a;
    }
}
