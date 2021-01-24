package com.sql.ehr.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.sql.ehr.entity.DepartmentEntity;
import com.sql.ehr.service.DepartmentService;




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
