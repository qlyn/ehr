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

import com.sql.ehr.entity.WorkcheckEntity;
import com.sql.ehr.service.WorkcheckService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/workcheck")
public class WorkcheckController {
    @Autowired
    private WorkcheckService workcheckService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr:workcheck:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = workcheckService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{wno}")
    @PreAuthorize("hasAuthority('ehr:workcheck:info')")
    public Resp<WorkcheckEntity> info(@PathVariable("wno") String wno){
		WorkcheckEntity workcheck = workcheckService.getById(wno);

        return Resp.ok(workcheck);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:workcheck:save')")
    public Resp<Object> save(@RequestBody WorkcheckEntity workcheck){
		workcheckService.save(workcheck);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:workcheck:update')")
    public Resp<Object> update(@RequestBody WorkcheckEntity workcheck){
		workcheckService.updateById(workcheck);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:workcheck:delete')")
    public Resp<Object> delete(@RequestBody String[] wnos){
		workcheckService.removeByIds(Arrays.asList(wnos));

        return Resp.ok(null);
    }

}
