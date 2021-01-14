package com.sql.ehr.controller;

import java.util.Arrays;
import java.util.Map;


import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.sql.ehr.entity.ApplyEntity;
import com.sql.ehr.service.ApplyService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
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
    @PreAuthorize("hasAuthority('ehr:apply:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = applyService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{ano}")
    @PreAuthorize("hasAuthority('ehr:apply:info')")
    public Resp<ApplyEntity> info(@PathVariable("ano") String ano){
		ApplyEntity apply = applyService.getById(ano);

        return Resp.ok(apply);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:apply:save')")
    public Resp<Object> save(@RequestBody ApplyEntity apply){
		applyService.save(apply);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:apply:update')")
    public Resp<Object> update(@RequestBody ApplyEntity apply){
		applyService.updateById(apply);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:apply:delete')")
    public Resp<Object> delete(@RequestBody String[] anos){
		applyService.removeByIds(Arrays.asList(anos));

        return Resp.ok(null);
    }

}
