package com.sql.ehr.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import com.sql.ehr.entity.EmployeeEntity;
import com.sql.ehr.entity.PermissionEntity;
import com.sql.ehr.entity.RoleEntity;
import com.sql.ehr.service.EmployeeService;
import com.sql.ehr.service.Employee_RoleService;
import com.sql.ehr.service.PermissionService;
import com.sql.ehr.service.Role_PermissionService;
import com.sql.ehr.util.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @Autowired
    RedisTools redisTools;

    @Autowired
    private Employee_RoleService employee_roleService;
    @Autowired
    private Role_PermissionService role_permissionService;

    @Autowired
    PermissionService permissionService;
    @Autowired
    MenuTools menuTools;

    /**
     * 根据用户查询所拥有角色
     * @param request
     * @return
     */
    @GetMapping("/selectRoleByEno")
    public String selectRoleByEno(HttpServletRequest request) {
        System.out.println("eno:"+request.getParameter("eno"));
        return JSONObjectTools.objectToJSONOString(employee_roleService.selectRoleidByEno(request.getParameter("eno")));
    }
    @GetMapping("/selectRoleListByEno")
    public List<RoleEntity> selectRoleListByEno(@RequestParam HashMap<String,Object> map) {
        return employee_roleService.selectRoleidByEno((String)map.get("eno"));
    }

    /**
     * 通过用户名查询账户
     * @param account
     * @return
     */
    @GetMapping("/selectByAccount")
    public EmployeeEntity selectByAccount(String account) {
        return employeeService.selectByAccount(account);
    }
    /**
     * 通过用户id查询菜单
     * @param map
     * @return
     */
    @GetMapping("/selectMenuByEno")
    public Map<String, Object> selectMenuByEno(@RequestParam HashMap<String,Object> map){


        List<RoleEntity> roleList=employee_roleService.selectRoleidByEno((String) map.get("eno"));
        List permissionList=new LinkedList();
        for(RoleEntity role:roleList){
            permissionList.addAll(role_permissionService.selectPermissionByRoleid(role.getRoleid()));
        }

        return menuTools.createMenu(permissionList);
    }

    /**
     * 根据角色查询所拥有权限
     * @param request
     * @return
     */
    @GetMapping("/selectPermissionByRoleid")
    public String selectPermissionByRoleid(HttpServletRequest request){
        return JSONObjectTools.objectToJSONOString(role_permissionService.selectPermissionByRoleid(request.getParameter("roleid")));
    }

    /**
     * 根据用户查询所拥有的权限（先查相关用户，用户再查相关联的权限）
     * @param request
     * @return
     */
    @GetMapping("/selectPermissionByEno")
    public String selectPermissionByEno(HttpServletRequest request){
        List<RoleEntity> roleList=employee_roleService.selectRoleidByEno(request.getParameter("eno"));
        List permissionList=new LinkedList();
        for(RoleEntity role:roleList){
            permissionList.addAll(role_permissionService.selectPermissionByRoleid(role.getRoleid()));
        }
        return JSONObjectTools.objectToJSONOString(permissionList);
    }
    /**
     * 分页查询（根据传来的分页参数进行的分页查询）
     * @param queryCondition
     * @return
     */
    //查询操作：判断key是否存在，如果存在则直接返回数据即不作任何操作；如果不存在则到数据库查询并存入redis，再从redis里取数据
    @GetMapping("/selectAllByPage")
    public JSONObject selectAllByPage(QueryCondition queryCondition) {
        //使用当前类名：方法名作为key
        String className=Thread.currentThread().getStackTrace()[1].getClassName();
        String methodName=Thread.currentThread().getStackTrace()[1].getMethodName();
        String key=className+":"+methodName;
        if(!redisTools.redisTemplate.hasKey(key)){
            PageVo page = employeeService.selectAllByPage(queryCondition);
            redisTools.set(key,Resp.customize(page,200,""));
        }
        return redisTools.get(key);
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
        }catch (Exception e){
            return "编辑失败";
        }
        redisTools.deleteNameSpace(Thread.currentThread().getStackTrace()[1].getClassName());
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
        String str="删除成功";
        try {
            employeeService.removeByIds(list);
        }catch (Exception e){
            str=e.getMessage();
        }
        redisTools.deleteNameSpace(Thread.currentThread().getStackTrace()[1].getClassName());
        return str;
    }

    /**
     * 删除
     * @param eno
     * @return
     */
    @DeleteMapping("/delete")
    public String delete(@RequestParam("eno") String eno) {
        String str="删除成功";
        try {
            employeeService.removeById(eno);
        }catch (Exception e){
            str=e.getMessage();
        }
        redisTools.deleteNameSpace(Thread.currentThread().getStackTrace()[1].getClassName());
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
        redisTools.deleteNameSpace(Thread.currentThread().getStackTrace()[1].getClassName());
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
        String path= ExcelTools.mapToExcel(head, (List<Map>) page.getList(),"test","test.xls",response);
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
