package com.sql.webpages.controller;

import com.sql.ehr.local.entity.EmployeeEntity;
import com.sql.ehr.local.entity.RoleEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(value = "ehr-local")
public interface EmployeeController {
    @GetMapping("ehr/employee/selectMenuByEno")
    public Map<String, Object> selectMenuByEno(@RequestParam HashMap<String,Object> map);
    @GetMapping("ehr/employee/selectByAccount")
    public EmployeeEntity selectByAccount(String account);
    @GetMapping("ehr/employee/selectRoleListByEno")
    public List<RoleEntity> selectRoleListByEno(@RequestParam HashMap<String,Object> map);
}
