package com.TianZeXin.controller;

import com.TianZeXin.flection.Resourse;
import com.TianZeXin.service.UserService;

public class UserController {
    @Resourse(value="service.iml.UserServiceIml")
    private static UserService service;

    public void test() {
        System.out.println("controller注册成功");
    }
    //登录
    public boolean login(String username,String password){
        System.out.println("登录成功");
        return service.login(username,password);
    }
    //注册
    public boolean regist(String username,String password){
        return service.regist(username,password);
    }
}
