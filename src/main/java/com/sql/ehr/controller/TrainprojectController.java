package com.sql.ehr.controller;

import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import com.sql.ehr.entity.TrainprojectEntity;
import com.sql.ehr.service.TrainprojectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/trainproject")
public class TrainprojectController {
    @Autowired
    private TrainprojectService trainprojectService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = trainprojectService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{tpno}")
    public Resp<TrainprojectEntity> info(@PathVariable("tpno") String tpno){
		TrainprojectEntity trainproject = trainprojectService.getById(tpno);

        return Resp.ok(trainproject);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody TrainprojectEntity trainproject){
		trainprojectService.save(trainproject);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody TrainprojectEntity trainproject){
		trainprojectService.updateById(trainproject);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody String[] tpnos){
		trainprojectService.removeByIds(Arrays.asList(tpnos));

        return Resp.ok(null);
    }

}
