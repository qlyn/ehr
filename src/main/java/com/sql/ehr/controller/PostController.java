package com.sql.ehr.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sql.ehr.entity.PostEntity;
import com.sql.ehr.service.PostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("ehr/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getAll")
    @Cacheable(cacheNames = "PostController_getAll",sync=true)
    public String getAll(@RequestParam("id")String id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.in("pdno",id);

        List<PostEntity> list=postService.list(queryWrapper);
        return JSONObject.toJSONString(list);
    }
}
