package com.sql.webpages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("getData")
public class GetDataController {
    @Autowired
    EmployeeController employeeController;
    @GetMapping("/selectMenuByEno")
    public Map<String, Object> selectMenuByEno(@RequestParam HashMap<String,Object> map){
        System.out.println("执行iselectMenuByEno方法:"+map);
        return employeeController.selectMenuByEno(map);
    }
    //所有用户可访问的接口
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    //只有admin用户能访问接口
    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }
    //user用户能访问接口，同时所有 user 能够访问的资源，admin 都能够访问
    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }
}
