package com.group.kve.controller;


import com.group.kve.service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    private RequestServiceImpl requestServiceImpl;

    @GetMapping("getHello")
    public String getHello(){
       return requestServiceImpl.getHelloService();
    }

}

