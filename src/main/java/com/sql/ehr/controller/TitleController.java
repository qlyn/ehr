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

import com.sql.ehr.entity.TitleEntity;
import com.sql.ehr.service.TitleService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr:title:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = titleService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tno}")
    @PreAuthorize("hasAuthority('ehr:title:info')")
    public Resp<TitleEntity> info(@PathVariable("tno") String tno){
		TitleEntity title = titleService.getById(tno);

        return Resp.ok(title);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:title:save')")
    public Resp<Object> save(@RequestBody TitleEntity title){
		titleService.save(title);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:title:update')")
    public Resp<Object> update(@RequestBody TitleEntity title){
		titleService.updateById(title);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:title:delete')")
    public Resp<Object> delete(@RequestBody String[] tnos){
		titleService.removeByIds(Arrays.asList(tnos));

        return Resp.ok(null);
    }

}
