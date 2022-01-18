package com.sql.ehr.local.service.impl;

import com.sql.ehr.local.core.bean.Query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.TitleDao;
import com.sql.ehr.local.entity.TitleEntity;
import com.sql.ehr.local.service.TitleService;
import org.springframework.stereotype.Service;

;


@Service("titleService")
public class TitleServiceImpl extends ServiceImpl<TitleDao, TitleEntity> implements TitleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TitleEntity> page = this.page(
                new Query<TitleEntity>().getPage(params),
                new QueryWrapper<TitleEntity>()
        );

        return new PageVo(page);
    }

}