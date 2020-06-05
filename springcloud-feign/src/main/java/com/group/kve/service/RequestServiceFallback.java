package com.group.kve.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestServiceFallback implements FallbackFactory<RequestService> {

    @Override
    public RequestService create(Throwable throwable) {
        return new RequestService() {
            @Override
            public String getHelloRequest() {
                return "ERROR 404";
            }
        };
    }
}
