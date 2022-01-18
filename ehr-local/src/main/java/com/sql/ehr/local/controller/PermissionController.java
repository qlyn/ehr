package com.sql.ehr.local.controller;


import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.PermissionEntity;
import com.sql.ehr.local.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 权限表（菜单表）
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "权限表（菜单表） 管理")
@RestController
@RequestMapping("ehr/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:permission:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = permissionService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{pno}")
    @PreAuthorize("hasAuthority('ehr.local:permission:info')")
    public Resp<PermissionEntity> info(@PathVariable("pno") Integer pno){
		PermissionEntity permission = permissionService.getById(pno);

        return Resp.ok(permission);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:permission:save')")
    public Resp<Object> save(@RequestBody PermissionEntity permission){
		permissionService.save(permission);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:permission:update')")
    public Resp<Object> update(@RequestBody PermissionEntity permission){
		permissionService.updateById(permission);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:permission:delete')")
    public Resp<Object> delete(@RequestBody Integer[] pnos){
		permissionService.removeByIds(Arrays.asList(pnos));

        return Resp.ok(null);
    }

}
