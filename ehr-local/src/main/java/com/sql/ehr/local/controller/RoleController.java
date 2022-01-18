package com.sql.ehr.local.controller;


import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 角色表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "角色表 管理")
@RestController
@RequestMapping("ehr/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:role:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = roleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{rno}")
    @PreAuthorize("hasAuthority('ehr.local:role:info')")
    public Resp<RoleEntity> info(@PathVariable("rno") Integer rno){
		RoleEntity role = roleService.getById(rno);

        return Resp.ok(role);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:role:save')")
    public Resp<Object> save(@RequestBody RoleEntity role){
		roleService.save(role);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:role:update')")
    public Resp<Object> update(@RequestBody RoleEntity role){
		roleService.updateById(role);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:role:delete')")
    public Resp<Object> delete(@RequestBody Integer[] rnos){
		roleService.removeByIds(Arrays.asList(rnos));

        return Resp.ok(null);
    }

}
