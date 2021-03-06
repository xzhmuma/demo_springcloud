package com.example.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        String a = restTemplate.getForEntity("http://discovery-service/add?a=10&b=20", String.class).getBody();
        System.out.println(a);

        return a;
    }

    public String addFallback() {

        return "error";
    }
}
