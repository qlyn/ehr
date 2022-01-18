package com.sql.ehr.local.controller;

import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.ApplyEntity;
import com.sql.ehr.local.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 员工申请职称信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Api(tags = "员工申请职称信息表 管理")
@RestController
@RequestMapping("ehr/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr.local:apply:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = applyService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{ano}")
    @PreAuthorize("hasAuthority('ehr.local:apply:info')")
    public Resp<ApplyEntity> info(@PathVariable("ano") Integer ano){
		ApplyEntity apply = applyService.getById(ano);

        return Resp.ok(apply);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr.local:apply:save')")
    public Resp<Object> save(@RequestBody ApplyEntity apply){
		applyService.save(apply);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr.local:apply:update')")
    public Resp<Object> update(@RequestBody ApplyEntity apply){
		applyService.updateById(apply);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr.local:apply:delete')")
    public Resp<Object> delete(@RequestBody Integer[] anos){
		applyService.removeByIds(Arrays.asList(anos));

        return Resp.ok(null);
    }

}
