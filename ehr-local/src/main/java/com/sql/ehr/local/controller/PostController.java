package com.sql.ehr.local.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sql.ehr.local.entity.PostEntity;
import com.sql.ehr.local.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 岗位基本信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Api(tags = "岗位基本信息表 管理")
@RestController
@RequestMapping("ehr/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getAll")
    public String getAll(@RequestParam("id")String id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.in("department_no",id);
        List<PostEntity> list=postService.list(queryWrapper);
        return JSONObject.toJSONString(list);
    }
}