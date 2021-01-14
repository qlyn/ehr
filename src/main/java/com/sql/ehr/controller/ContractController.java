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

import com.sql.ehr.entity.ContractEntity;
import com.sql.ehr.service.ContractService;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ehr:contract:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = contractService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{cno}")
    @PreAuthorize("hasAuthority('ehr:contract:info')")
    public Resp<ContractEntity> info(@PathVariable("cno") String cno){
		ContractEntity contract = contractService.getById(cno);

        return Resp.ok(contract);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ehr:contract:save')")
    public Resp<Object> save(@RequestBody ContractEntity contract){
		contractService.save(contract);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ehr:contract:update')")
    public Resp<Object> update(@RequestBody ContractEntity contract){
		contractService.updateById(contract);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('ehr:contract:delete')")
    public Resp<Object> delete(@RequestBody String[] cnos){
		contractService.removeByIds(Arrays.asList(cnos));

        return Resp.ok(null);
    }

}
