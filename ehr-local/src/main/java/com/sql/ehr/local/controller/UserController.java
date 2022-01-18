package com.sql.ehr.local.controller;


import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.entity.UserEntity;
import com.sql.ehr.local.service.RolePermissionService;
import com.sql.ehr.local.service.UserRoleService;
import com.sql.ehr.local.service.UserService;
import com.sql.ehr.local.util.JSONObjectTools;
import com.sql.ehr.local.util.MenuTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 用户表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Api(tags = "用户表 管理")
@RestController
@RequestMapping("ehr/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    MenuTools menuTools;

    @Autowired
    private RolePermissionService rolePermissionService;
    /**
     * 根据用户查询所拥有角色
     * @param request
     * @return
     */
    @GetMapping("/selectRoleByUaccount")
    public String selectRoleByUaccount(HttpServletRequest request) {
        System.out.println("eno:"+request.getParameter("eno"));
        return JSONObjectTools.objectToJSONOString(userRoleService.selectRoleListByUaccount(request.getParameter("uaccount")));
    }
    @GetMapping("/selectRoleListByUaccount")
    public List<RoleEntity> selectRoleListByUaccount(@RequestParam HashMap<String,Object> map) {
        return userRoleService.selectRoleListByUaccount((String)map.get("uaccount"));
    }

    /**
     * 通过用户用户名查询菜单
     * @param map
     * @return
     */
    @GetMapping("/selectMenuByUaccount")
    public Map<String, Object> selectMenuByUaccount(@RequestParam HashMap<String,Object> map){


        List<RoleEntity> roleList=userRoleService.selectRoleListByUaccount((String) map.get("uaccount"));
        List permissionList=new LinkedList();
        for(RoleEntity role:roleList){
            permissionList.addAll(rolePermissionService.selectPermissionByRno(role.getRno()));
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
        return JSONObjectTools.objectToJSONOString(rolePermissionService.selectPermissionByRno(Integer.valueOf(request.getParameter("roleid"))));
    }

    /**
     * 根据用户查询所拥有的权限（先查相关用户，用户再查相关联的权限）
     * @param request
     * @return
     */
    @GetMapping("/selectPermissionByUaccount")
    public String selectPermissionByUaccount(HttpServletRequest request){
        List<RoleEntity> roleList=userRoleService.selectRoleListByUaccount(request.getParameter("uaccount"));
        List permissionList=new LinkedList();
        for(RoleEntity role:roleList){
            permissionList.addAll(rolePermissionService.selectPermissionByRno(role.getRno()));
        }
        return JSONObjectTools.objectToJSONOString(permissionList);
    }
















    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:user:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = userService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{uno}")
    @PreAuthorize("hasAuthority('ehr.local:user:info')")
    public Resp<UserEntity> info(@PathVariable("uno") Integer uno){
		UserEntity user = userService.getById(uno);

        return Resp.ok(user);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:user:save')")
    public Resp<Object> save(@RequestBody UserEntity user){
		userService.save(user);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:user:update')")
    public Resp<Object> update(@RequestBody UserEntity user){
		userService.updateById(user);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:user:delete')")
    public Resp<Object> delete(@RequestBody Integer[] unos){
		userService.removeByIds(Arrays.asList(unos));

        return Resp.ok(null);
    }

}
