package com.sql.ehr.local.controller;

import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.TrainrecordEntity;
import com.sql.ehr.local.service.TrainrecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 培训记录表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "培训记录表 管理")
@RestController
@RequestMapping("ehr/trainrecord")
public class TrainrecordController {
    @Autowired
    private TrainrecordService trainrecordService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = trainrecordService.queryPage(queryCondition);
        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{trno}")
    public Resp<TrainrecordEntity> info(@PathVariable("trno") String trno){
        TrainrecordEntity trainrecord = trainrecordService.getById(trno);

        return Resp.ok(trainrecord);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody TrainrecordEntity trainrecord){
        trainrecordService.save(trainrecord);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody TrainrecordEntity trainrecord){
        trainrecordService.updateById(trainrecord);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody String[] trnos){
        trainrecordService.removeByIds(Arrays.asList(trnos));

        return Resp.ok(null);
    }

}
