package com.sql.ehr.local.controller;

import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.core.bean.Resp;
import com.sql.ehr.local.entity.TrainprojectEntity;
import com.sql.ehr.local.service.TrainprojectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;




/**
 * 培训项目表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Api(tags = "培训项目表 管理")
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
