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

import com.sql.ehr.entity.TransferEntity;
import com.sql.ehr.service.TransferService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr:transfer:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = transferService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tno}")
    @PreAuthorize("hasAuthority('ehr:transfer:info')")
    public Resp<TransferEntity> info(@PathVariable("tno") String tno){
		TransferEntity transfer = transferService.getById(tno);

        return Resp.ok(transfer);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:transfer:save')")
    public Resp<Object> save(@RequestBody TransferEntity transfer){
		transferService.save(transfer);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:transfer:update')")
    public Resp<Object> update(@RequestBody TransferEntity transfer){
		transferService.updateById(transfer);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:transfer:delete')")
    public Resp<Object> delete(@RequestBody String[] tnos){
		transferService.removeByIds(Arrays.asList(tnos));

        return Resp.ok(null);
    }

}
