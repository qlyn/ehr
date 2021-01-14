package com.sql.ehr.controller;

import com.alibaba.nacos.client.naming.net.HttpClient;
import com.sql.ehr.service.ArchivesService;
import com.sql.ehr.service.EmployeeService;
import com.sql.ehr.util.ExcelTools;
import com.sql.ehr.util.RequestParamsTools;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Excek导出工具类
 * 1、自动装配Service以便后面调用要导出的数据方法
 * 2、请求参数包含url、以及该url要调用参数
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/general")
public class GeneralController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ArchivesService archivesService;
    @GetMapping("/exportAllData")
    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = true)
    public void exportAllData(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String,Object> hashMap=RequestParamsTools.RequestParamsToMap(request);
        String url=(String) hashMap .get("url");
        System.out.println("hashmap:"+hashMap);
        System.out.println("url:"+url);
        List<Map> list = null;
        if(url.contains("employee")){
            if(url.contains("selectAllByPage")) {
                list = employeeService.selectAllByExport();
            }else if(url.contains("selectAllByCondition")){
                list=  employeeService.selectAllByConditionExport(hashMap);
            }
        }else if(url.contains("archives")){
            if(url.contains("selectAllByPage")) {
                list = archivesService.selectAllByExport();
            }else if(url.contains("selectAllByCondition")){
                list=  archivesService.selectAllByConditionExport(hashMap);
            }
        }
        LinkedHashMap<String, String> head=new LinkedHashMap<>();
        //设置表头
        head.put("eno","员工编号");
        head.put("ename","姓名");
        head.put("egender","性别");
        head.put("ebirthday","出生日期");
        head.put("ephone","联系电话");
        head.put("eemail","邮箱地址");
        head.put("eeducation","学历");
        head.put("dname","部门");
        head.put("pname","职务");
        head.put("eentytime","入职时间");
        head.put("estatus","人员状态");
        head.put("erole","角色");
        head.put("eremarks","备注");
        String path= ExcelTools.mapToExcel(head, list,"test","test.xls",response);
    }
}
