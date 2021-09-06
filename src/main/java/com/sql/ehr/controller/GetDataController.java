package com.sql.ehr.controller;

import com.sql.ehr.configuration.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class GetDataController {
    @Autowired
    HolisticController holisticController;
    //获取注册时邮箱验证码
    @GetMapping("/getRegisterCode")
    public String getRegisterCode(@RequestParam HashMap<String,Object> map){
        System.out.println(map);
        //生成随机六位注册码
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer registerCode = new StringBuffer();
        for (int i = 0; i < 6; i++)
        {
            registerCode.append(sources.charAt(rand.nextInt(9)) + "");
        }
        map.put("registerCode",registerCode);
        holisticController.sendEmail(map);
        return (String) map.get("eemail");
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


    @RequestMapping("/get")
    public String get(){
        HashMap map = new HashMap();
        map.put("username","admin");
        map.put("password","123456");
        map.put("message","成功访问");
        return map.toString();
    }
    //需要admin用户才能访问的接口，为什么加上ROLE_：因为SpringSecurity里的角色都需要加上该前缀，CustomUserService里的同理也需要加上该前缀。
    @PreAuthorize("hasAuthority('ROLE_admin')")
    @RequestMapping("/del")
    public String del(){
        return "删除成功";
    }
}