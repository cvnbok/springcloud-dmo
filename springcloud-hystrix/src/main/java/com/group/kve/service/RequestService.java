package com.group.kve.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class RequestService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "getHelloFallBack")
    public String getHello(){
       /*
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String host = instance.getHost();
        int port = instance.getPort();
        String str= restTemplate.getForEntity("http://eureka-client"+"/getHello",String.class).getBody();
        System.out.println("负载均衡请求："+str+" # "+host+":"+port);
        return "负载均衡请求:"+str;
        */
        return restTemplate.getForEntity("http://eureka-client"+"/getHello1",String.class).getBody();
    }

    public String getHelloFallBack(){
       log.info("***********************************");
        return "error:404 ";
    }
}
