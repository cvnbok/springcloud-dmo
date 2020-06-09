package com.group.kve.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public class UserController {

    @RequestMapping("addUser")
    public String addUser(){
        return "新增用户";
    }


    @RequestMapping("delUser")
    public String delUser(){
        return "删除用户";
    }

    @RequestMapping("queryUser")
    public String queryUser(){
        return "查询用户";
    }



}
