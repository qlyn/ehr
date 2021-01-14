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

import com.sql.ehr.entity.PayEntity;
import com.sql.ehr.service.PayService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/pay")
public class PayController {
    @Autowired
    private PayService payService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr:pay:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = payService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{wno}")
    @PreAuthorize("hasAuthority('ehr:pay:info')")
    public Resp<PayEntity> info(@PathVariable("wno") String wno){
		PayEntity pay = payService.getById(wno);

        return Resp.ok(pay);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:pay:save')")
    public Resp<Object> save(@RequestBody PayEntity pay){
		payService.save(pay);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:pay:update')")
    public Resp<Object> update(@RequestBody PayEntity pay){
		payService.updateById(pay);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:pay:delete')")
    public Resp<Object> delete(@RequestBody String[] wnos){
		payService.removeByIds(Arrays.asList(wnos));

        return Resp.ok(null);
    }

}
