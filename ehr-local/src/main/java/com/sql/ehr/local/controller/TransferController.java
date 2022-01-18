package com.sql.ehr.local.controller;

import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.TransferEntity;
import com.sql.ehr.local.service.TransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 人事调动信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "人事调动信息表 管理")
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
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = transferService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tno}")
    public Resp<TransferEntity> info(@PathVariable("tno") String tno){
        TransferEntity transfer = transferService.getById(tno);

        return Resp.ok(transfer);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody TransferEntity transfer){
        transferService.save(transfer);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody TransferEntity transfer){
        transferService.updateById(transfer);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody String[] tnos){
        transferService.removeByIds(Arrays.asList(tnos));

        return Resp.ok(null);
    }

}
