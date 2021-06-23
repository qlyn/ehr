package com.sql.ehr.controller;

import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.core.bean.Resp;
import com.sql.ehr.entity.RecruitEntity;
import com.sql.ehr.service.RecruitService;
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
@RequestMapping("ehr/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = recruitService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{rno}")
    public Resp<RecruitEntity> info(@PathVariable("rno") String rno){
		RecruitEntity recruit = recruitService.getById(rno);

        return Resp.ok(recruit);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody RecruitEntity recruit){
		recruitService.save(recruit);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody RecruitEntity recruit){
		recruitService.updateById(recruit);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody String[] rnos){
		recruitService.removeByIds(Arrays.asList(rnos));

        return Resp.ok(null);
    }

}
