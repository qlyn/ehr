package com.sql.ehr.local.controller;

import com.alibaba.fastjson.JSONObject;
import com.sql.ehr.local.entity.DepartmentEntity;
import com.sql.ehr.local.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 部门基本信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Api(tags = "部门基本信息表 管理")
@RestController
@RequestMapping("ehr/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/getAll")
    public String getAll() {
        List<DepartmentEntity> list=departmentService.list();
        return JSONObject.toJSONString(list);
    }

}