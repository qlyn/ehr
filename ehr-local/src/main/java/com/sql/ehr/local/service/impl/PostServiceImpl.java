package com.sql.ehr.local.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.PostDao;
import com.sql.ehr.local.entity.PostEntity;
import com.sql.ehr.local.service.PostService;
import org.springframework.stereotype.Service;

;


@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostDao, PostEntity> implements PostService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<PostEntity> page = this.page(
                new Query<PostEntity>().getPage(params),
                new QueryWrapper<PostEntity>()
        );

        return new PageVo(page);
    }

}