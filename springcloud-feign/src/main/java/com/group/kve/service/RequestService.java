package com.group.kve.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client",fallbackFactory = RequestServiceFallback.class)
public interface RequestService {
    @GetMapping("getHello")
    public String getHelloRequest();
}
