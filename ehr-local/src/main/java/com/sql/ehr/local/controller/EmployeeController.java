package com.sql.ehr.local.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sql.ehr.external.dto.RecruitEntity;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.core.query.InductionQuery;
import com.sql.ehr.local.entity.EmployeeEntity;
import com.sql.ehr.local.feign.RecruitController;
import com.sql.ehr.local.service.EmployeeService;
import com.sql.ehr.local.service.PermissionService;
import com.sql.ehr.local.util.BeanUtil;
import com.sql.ehr.local.util.ExcelTools;
import com.sql.ehr.local.util.RedisTools;
import com.sql.ehr.local.util.RequestParamsTools;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 员工基本信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "员工基本信息表 管理")
@RestController
@RequestMapping("ehr/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @Autowired
    RedisTools redisTools;


    @Autowired
    PermissionService permissionService;

    @Autowired
    RecruitController recruitController;
    @PostMapping("/induction")
    @ApiOperation("入职")
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public String induction(@RequestBody InductionQuery inductionQuery) {
        RecruitEntity recruitEntity=BeanUtil.objConvert(inductionQuery,RecruitEntity.class);
        recruitEntity.setNo(inductionQuery.getRno());
        recruitEntity.setStatus("3");
        recruitController.update(recruitEntity);
        int i=0;
        if(i!=1) {
            throw new RuntimeException("测试异常！！");
        }
        EmployeeEntity employeeEntity= BeanUtil.objConvert(inductionQuery,EmployeeEntity.class);
        employeeService.save(employeeEntity);
        redisTools.deleteNameSpace(employeeEntity.getNo());
        return "添加成功";
    }

    /**
     * 分页查询（根据传来的分页参数进行的分页查询）
     * @param queryCondition
     * @return
     */
    //查询操作：判断key是否存在，如果存在则直接返回数据即不作任何操作；如果不存在则到数据库查询并存入redis，再从redis里取数据
    @GetMapping("/selectAllByPage")
    public Resp<PageVo> selectAllByPage(QueryCondition queryCondition) {
        PageVo page = employeeService.selectAllByPage(queryCondition);
        return Resp.customize(page,200,"");
    }

    /**
     * 条件查询（根据传来的查询条件（如姓名，性别）进行的查询）
     * @return
     */
    @GetMapping("/selectAllByCondition")
    public Resp<PageVo> selectAllByCondition(HttpServletRequest request) {
        PageVo page = employeeService.selectAllByCondition(RequestParamsTools.RequestParamsToMap(request));
        return Resp.customize(page,200,"");
    }


    /**
     * 编辑
     * @param jsonObject
     * @return
     */
    //增删改操作：如果redis有缓存，则删除掉该缓存，保持redis和关系型数据库里数据一致性
    @PutMapping("/edit")
    public String edit(@RequestBody JSONObject jsonObject){
        try {
            EmployeeEntity employee =JSONObject.toJavaObject(jsonObject,EmployeeEntity.class);
            employeeService.updateById(employee);
            redisTools.deleteNameSpace(employee.getNo());
        }catch (Exception e){
            return "编辑失败";
        }
        return "编辑成功";
    }

    /**
     * 批量删除
     * @param jsonArray
     * @return
     */
    @DeleteMapping("/batchDelete")
    @Transactional  //批量处理数据，使用事务管理
    public String batchDelete(@RequestBody JSONArray jsonArray) {
        List<String> list=jsonArray.toJavaList(String.class);
        try {
            employeeService.removeByIds(list);
            for(String str:list){
                redisTools.deleteNameSpace(str);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "删除成功";
    }

    /**
     * 删除
     * @param no
     * @return
     */
    @DeleteMapping("/delete")
    public String delete(@RequestParam("no") String no) {
        String str="删除成功";
        try {
            employeeService.removeById(no);
            redisTools.deleteNameSpace(no);
        }catch (Exception e){
            str=e.getMessage();
        }
        return str;
    }

    /**
     * 添加
     * @param jsonObject
     * @return
     */
    @PostMapping("/add")
    public String add(@RequestBody JSONObject jsonObject) {
        EmployeeEntity employeeEntity=JSONObject.toJavaObject(jsonObject,EmployeeEntity.class);
        employeeService.save(employeeEntity);
        redisTools.deleteNameSpace(employeeEntity.getNo());
        return "添加成功";
    }

    /**
     * 全部文件导出excel
     * @param response
     */
    @GetMapping("/exportAllData")
    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = true)
    public void exportAllData(HttpServletResponse response) {
        List<Map> list= employeeService.selectAllByExport();
        LinkedHashMap<String, String> head=new LinkedHashMap<>();
        //设置表头
        head.put("no","员工编号");
        head.put("name","姓名");
        head.put("gender","性别");
        head.put("birthday","出生日期");
        head.put("phone","联系电话");
        head.put("email","邮箱地址");
        head.put("education","学历");
        head.put("dname","部门");
        head.put("pname","职务");
        head.put("entryTime","入职时间");
        head.put("status","人员状态");
        head.put("remarks","备注");
        String path= ExcelTools.mapToExcel(head, list,"职员表","data.xls",response);
    }

    /**
     * 部分文件导出excel
     * @param request
     * @param response
     */
    @GetMapping("/exportData")
    @Transactional(isolation= Isolation.REPEATABLE_READ,readOnly = true)
    public void exportData(HttpServletRequest request, HttpServletResponse response) {
        PageVo page = employeeService.selectAllByExport(RequestParamsTools.RequestParamsToMap(request));
        LinkedHashMap<String, String> head=new LinkedHashMap<>();
        //设置表头
        head.put("no","员工编号");
        head.put("name","姓名");
        head.put("gender","性别");
        head.put("birthday","出生日期");
        head.put("phone","联系电话");
        head.put("email","邮箱地址");
        head.put("education","学历");
        head.put("dname","部门");
        head.put("pname","职务");
        head.put("entryTime","入职时间");
        head.put("status","人员状态");
        head.put("remarks","备注");
        String path= ExcelTools.mapToExcel(head, (List<Map>) page.getList(),"职员表","data.xls",response);
    }
    /**
     * 老的分页方法
     * @param curr
     * @param nums
     * @return
     */
//    @GetMapping("/layuilist.json")
//    public JSONObject layuilist(@RequestParam(value = "curr",defaultValue = "1") int curr,@RequestParam(value = "nums",defaultValue = "10")int nums) {
//        if(Integer.valueOf(curr)<=0){
//            throw new RRException("当前页数不能为0");
//        }
//        PageVo page = employeeService.selectAllByPage(curr,nums);
//        return (JSONObject) JSONObject.toJSON(Resp.customize(page,200,""));
//    }
}