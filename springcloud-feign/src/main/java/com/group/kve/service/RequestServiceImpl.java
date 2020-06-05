package com.group.kve.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class RequestServiceImpl{

    @Autowired
    private RequestService requestService;

    @Autowired
    private DiscoveryClient client;

    public String getHelloService() {
        List<String> list= client.getServices();
        for (int i = 0; i < list.size(); i++) {
            log.info("client==="+i+" |"+list.get(i).toString());
        }
        return requestService.getHelloRequest();
    }
}
