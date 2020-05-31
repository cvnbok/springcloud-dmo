package com.group.kve.config;

import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/***
 * 自定义轮训规则
 */
@Configurable
public class myIRule {

    @Bean
    public IRule iRule(){
       // return new RandomRule();                  //随机轮训规则
       // return new RoundRobinRule();              //轮询策略 注：Ribbon默认策略
       // return new RetryRule();                   //重试策略
       // return new BestAvailableRule();           //最低并发策略
       // return new AvailabilityFilteringRule();   //可用过滤策略
       // return new WeightedResponseTimeRule();    //响应时间加权策略
       // return new ZoneAvoidanceRule();             //区域权衡策略
        return new MyRandomRule();        //自定义轮训规则
    }

    @Bean
    @LoadBalanced
    public RestTemplate rebbionRestTemplate(){
        return new RestTemplate();
    }
}
