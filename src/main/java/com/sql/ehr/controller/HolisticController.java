package com.sql.ehr.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@FeignClient(value = "ehr-email")
public interface HolisticController {
    @GetMapping("/sendEmail")
    public void sendEmail(@RequestParam HashMap<String,Object> map);
}
