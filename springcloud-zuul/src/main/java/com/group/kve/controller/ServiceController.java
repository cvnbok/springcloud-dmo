package com.group.kve.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("services")
public class ServiceController {


    @RequestMapping("addService")
    public String addService(){
        return "新增服务";
    }


    @RequestMapping("delService")
    public String delService(){
        return "删除服务";
    }

    @RequestMapping("queryService")
    public String queryService(){
        return "查询服务";
    }

}
