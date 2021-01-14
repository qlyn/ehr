package com.sql.ehr.controller;

import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import com.sql.ehr.service.ArchivesService;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/archives")
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;

    /**
     * 根据eno返回单条通用记录
     * @param eno
     * @return
     */
    @GetMapping("/selectSingleRecordById")
    public GeneralEmployee selectSingleRecordById(String eno){
        return archivesService.selectSingleRecordById(eno);
    }
    /**
     * 档案初始化查询（带分页）
     */
    @GetMapping("/selectAllByPage")
    public Resp<PageVo> selectAllByPage(QueryCondition queryCondition) {
        PageVo page = archivesService.selectAllByPage(queryCondition);
        return Resp.customize(page,200,"");
    }

    /**
     * 档案搜索按钮查询
     */
    @GetMapping("/selectAllByCondition")
    public Resp<PageVo> selectAllByCondition(HttpServletRequest request) {
        PageVo page = archivesService.selectAllByCondition(RequestParamsTools.RequestParamsToMap(request));
        return Resp.customize(page,200,"");
    }

    /**
     * 全部文件导出excel
     * @param response
     */
    @GetMapping("/exportAllData")
    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = true)
    public void exportAllData(HttpServletResponse response) {
        List<Map> list= archivesService.selectAllByExport();
        LinkedHashMap<String, String> head=new LinkedHashMap<>();
        //设置表头
        head.put("eno","员工编号");
        head.put("ename","姓名");
        head.put("dname","部门");
        head.put("pname","职务");
        head.put("aname","档案名称");
        head.put("acontent","档案内容");
        head.put("aremarks","档案备注");
        head.put("eentytime","入职时间");
        String path=ExcelTools.mapToExcel(head, list,"test","test.xls",response);
    }

    /**
     * 部分文件导出excel
     * @param request
     * @param response
     *
     */
    @GetMapping("/exportData")
    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = true)
    public void exportData(HttpServletRequest request,HttpServletResponse response) {
        PageVo page = archivesService.selectAllByExport(RequestParamsTools.RequestParamsToMap(request));
        LinkedHashMap<String, String> head=new LinkedHashMap<>();
        //设置表头
        head.put("eno","员工编号");
        head.put("ename","姓名");
        head.put("dname","部门");
        head.put("pname","职务");
        head.put("aname","档案名称");
        head.put("acontent","档案内容");
        head.put("aremarks","档案备注");
        head.put("eentytime","入职时间");
        String path=ExcelTools.mapToExcel(head, (List<Map>) page.getList(),"test","test.xls",response);
    }

}
