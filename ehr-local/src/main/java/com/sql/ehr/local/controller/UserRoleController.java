package com.sql.ehr.local.controller;


import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.UserRoleEntity;
import com.sql.ehr.local.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 用户角色表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "用户角色表 管理")
@RestController
@RequestMapping("ehr/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:userrole:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = userRoleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{userUno}")
    @PreAuthorize("hasAuthority('ehr.local:userrole:info')")
    public Resp<UserRoleEntity> info(@PathVariable("userUno") Integer userUno){
		UserRoleEntity userRole = userRoleService.getById(userUno);

        return Resp.ok(userRole);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:userrole:save')")
    public Resp<Object> save(@RequestBody UserRoleEntity userRole){
		userRoleService.save(userRole);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:userrole:update')")
    public Resp<Object> update(@RequestBody UserRoleEntity userRole){
		userRoleService.updateById(userRole);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:userrole:delete')")
    public Resp<Object> delete(@RequestBody Integer[] userUnos){
		userRoleService.removeByIds(Arrays.asList(userUnos));

        return Resp.ok(null);
    }

}
