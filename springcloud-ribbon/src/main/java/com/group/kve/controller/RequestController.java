package com.group.kve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/getHello",method = RequestMethod.GET)
    public String getHello(){
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String host = instance.getHost();
        int port = instance.getPort();
        String str= restTemplate.getForEntity("http://eureka-client"+"/getHello",String.class).getBody();
        System.out.println("负载均衡请求："+str+" # "+host+":"+port);
        return "负载均衡请求:"+str;
    }
    @RequestMapping(value = "/postHello",method = RequestMethod.GET)
    public String postHello(){
        String str = null;
        ResponseEntity<String> responseEntity= restTemplate.postForEntity("http://eureka-client"+"/getHello",null , String.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            str = responseEntity.getBody();
        }
        return "负载均衡请求:"+str;
    }


}

