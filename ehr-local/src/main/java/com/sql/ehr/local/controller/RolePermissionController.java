package com.sql.ehr.local.controller;


import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.RolePermissionEntity;
import com.sql.ehr.local.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 角色权限关联表（只关联最后的叶子菜单，即有跳转链接的菜单）
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Api(tags = "角色权限关联表（只关联最后的叶子菜单，即有跳转链接的菜单） 管理")
@RestController
@RequestMapping("ehr/rolepermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:rolepermission:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = rolePermissionService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{roleRno}")
    @PreAuthorize("hasAuthority('ehr.local:rolepermission:info')")
    public Resp<RolePermissionEntity> info(@PathVariable("roleRno") Integer roleRno){
		RolePermissionEntity rolePermission = rolePermissionService.getById(roleRno);

        return Resp.ok(rolePermission);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:rolepermission:save')")
    public Resp<Object> save(@RequestBody RolePermissionEntity rolePermission){
		rolePermissionService.save(rolePermission);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:rolepermission:update')")
    public Resp<Object> update(@RequestBody RolePermissionEntity rolePermission){
		rolePermissionService.updateById(rolePermission);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:rolepermission:delete')")
    public Resp<Object> delete(@RequestBody Integer[] roleRnos){
		rolePermissionService.removeByIds(Arrays.asList(roleRnos));

        return Resp.ok(null);
    }

}
