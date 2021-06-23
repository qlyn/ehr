package com.sql.ehr.controller;

import com.alibaba.fastjson.JSONObject;
import com.sql.ehr.entity.DepartmentEntity;
import com.sql.ehr.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
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
